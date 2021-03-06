package com.yyece.his.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.*;
import com.yyece.his.interceptor.JwtInterceptor;
import com.yyece.his.service.DoctorService;
import com.yyece.his.utils.IdWorker;
import com.yyece.his.utils.JwtUtils;
import org.apache.ibatis.annotations.Options;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

/**
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2020-03-11 22:57:58
 */
@RestController
@RequestMapping("doctor")
@CrossOrigin
public class DoctorController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;

    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IdWorker idWorker;

    /**
     * 分页查询所有数据
     *
     * @param
     * @param doctor 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Doctor> page, Doctor doctor) {
        QueryWrapper queryWrapper = new QueryWrapper<>(doctor);
        queryWrapper.eq("isdeleted", 0);
        return success(this.doctorService.page(page, queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.doctorService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param doctor 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Doctor doctor) {
        return success(this.doctorService.save(doctor));
    }

    @PostMapping("/save")
    public Result saveDoctor(@RequestBody Map<String, Object> map) {
        String account = "dr" + idWorker.nextId();
        map.put("account", account);
        boolean result = doctorService.saveDoctor(map);
        if (result) {
            Doctor doctor = doctorService.findDoctorByAccount(account);
            boolean setDoctorRoleResult = doctorService.setDoctorRole(doctor.getDoctorid());
            if (setDoctorRoleResult) {
                return new Result(ResultCode.SUCCESS);
            } else {
                return new Result(ResultCode.FAIL);
            }
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody Map<String, Object> map) {
        boolean result = doctorService.modify(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @Options(useGeneratedKeys = false)
    @PostMapping("/delete")
    public Result deleteByDoctorId(@RequestBody Map<String, Object> map) {
        boolean result = doctorService.deleteByDoctorId(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> loginMap) {
        String account = loginMap.get("account");
        String password = loginMap.get("password");
        Doctor doctor = doctorService.findDoctorByAccount(account);
        //登录失败
        if (doctor == null || !doctor.getPassword().equals(password)) {
            return new Result(ResultCode.MOBILEORPASSWORDERROR);
        } else {
            Map<String, Object> map = new HashMap<>();
            String token = jwtUtils.createJwt(doctor.getDoctorid().toString(), doctor.getAccount(), map);
            return new Result(ResultCode.SUCCESS, token);
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Result profile(HttpServletRequest request) throws Exception {

        String account = claims.getSubject();
        String doctorId = claims.getId();
        //获取用户信息
        Doctor doctor = doctorService.findDoctorByAccount(account);
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> roles = doctorService.getDoctorRoles(Integer.parseInt(doctorId));
        Set authSet = new HashSet();

        for (Map<String, Object> role : roles) {
            List<Map<String, Object>> auths = doctorService.getRoleAuth((Integer) role.get("roleId"));
            for (Map<String, Object> auth : auths) {
                authSet.add(auth);
            }
        }

        map.put("doctorid", doctor.getDoctorid());
        map.put("account", doctor.getAccount());
        map.put("doctorname", doctor.getDoctorname());
        map.put("skilledfield", doctor.getSkilledfield());
        map.put("departmentid", doctor.getDepartmentid());
        map.put("departmentname", doctor.getDepartmentname());
        map.put("doctortitle", doctor.getDoctortitle());
        map.put("practiceexperience", doctor.getPracticeexperience());
        map.put("roles", roles);
        map.put("auth", authSet);
        return new Result(ResultCode.SUCCESS, map);
    }
}