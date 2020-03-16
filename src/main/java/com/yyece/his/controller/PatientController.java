package com.yyece.his.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Doctor;
import com.yyece.his.entity.Patient;
import com.yyece.his.entity.Result;
import com.yyece.his.entity.ResultCode;
import com.yyece.his.service.PatientService;
import com.yyece.his.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2020-03-16 10:57:59
 */
@RestController
@RequestMapping("patient")
public class PatientController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private PatientService patientService;

    @Autowired
    private JwtUtils jwtUtils   ;
    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param patient 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Patient> page, Patient patient) {
        return success(this.patientService.page(page, new QueryWrapper<>(patient)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.patientService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param patient 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Patient patient) {
        return success(this.patientService.save(patient));
    }

    /**
     * 修改数据
     *
     * @param patient 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Patient patient) {
        return success(this.patientService.updateById(patient));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.patientService.removeByIds(idList));
    }


    @PostMapping("/modify")
    public Result modify(@RequestBody Map<String, Object> map) {
        boolean result = patientService.modify(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/register")
    public Result saveDoctor(@RequestBody Map<String, Object> map) {
        String phone = (String) map.get("phone");
        Patient patient = patientService.findPatientByPhone(phone);
        if (patient != null) {
            return new Result(ResultCode.PATIENT_EXISTED);
        } else {
            boolean result = patientService.savePatient(map);
            if (result) {
                return new Result(ResultCode.SUCCESS);
            } else {
                return new Result(ResultCode.FAIL);
            }
        }

    }

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> loginMap) {
        String phone = loginMap.get("phone");
        String password = loginMap.get("password");
        Patient patient = patientService.findPatientByPhone(phone);
        //登录失败
        if (patient == null) {
            return new Result(ResultCode.NOTFOUND_PATIENT);
        } else if (!patient.getPassword().equals(password)) {
            return new Result(ResultCode.MOBILEORPASSWORDERROR);
        } else {
            Map<String, Object> map = new HashMap<>();
            String token = jwtUtils.createJwt(patient.getPatientid().toString(), patient.getPhone(), map);
            return new Result(ResultCode.SUCCESS, token);
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Result profile(HttpServletRequest request) throws Exception {

        String phone = claims.getSubject();
        String patientid = claims.getId();
        //获取用户信息
        Patient patient = patientService.findPatientByPhone(phone);
        Map<String, Object> map = new HashMap<>();

        map.put("patientId", patientid);
        map.put("phone", phone);
        map.put("patientName", patient.getPatientname());
        map.put("birthDate", patient.getBirthdate());
        map.put("gender", patient.getGender());
        return new Result(ResultCode.SUCCESS, map);
    }

}