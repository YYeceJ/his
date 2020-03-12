package com.yyece.his.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.*;
import com.yyece.his.interceptor.JwtInterceptor;
import com.yyece.his.service.DoctorService;
import com.yyece.his.utils.JwtUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2020-03-11 22:57:58
 */
@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;

    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param doctor 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Doctor> page, Doctor doctor) {
        return success(this.doctorService.page(page, new QueryWrapper<>(doctor)));
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

    /**
     * 修改数据
     *
     * @param doctor 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Doctor doctor) {
        return success(this.doctorService.updateById(doctor));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.doctorService.removeByIds(idList));
    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> loginMap) {
        String account = loginMap.get("account");
        String password = loginMap.get("password");
        Doctor doctor = doctorService.findDoctorByAccount(account);
        System.out.println(doctor);
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
        JSONObject jo = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> roles = doctorService.getDoctorRoles(Integer.parseInt(doctorId));
        //根据不同的用户级别获取用户角色
        map.put("doctorid",doctor.getDoctorid());
        map.put("account",doctor.getAccount());
        map.put("doctorname",doctor.getDoctorname());
        map.put("skilledfield",doctor.getSkilledfield());
        map.put("departmentid",doctor.getDepartmentid());
        map.put("departmentname",doctor.getDepartmentname());
        map.put("doctortitle",doctor.getDoctortitle());
        map.put("practiceexperience",doctor.getPracticeexperience());
        map.put("roles",roles);
        return new Result(ResultCode.SUCCESS, map);
    }
}