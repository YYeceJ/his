package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.Doctor;
import com.yyece.his.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * (Doctor)表服务接口
 *
 * @author makejava
 * @since 2020-03-11 22:57:58
 */
public interface DoctorService extends IService<Doctor> {
    Doctor findDoctorByAccount(String account);

    List<Map<String, Object>> getDoctorRoles(int doctorId);

    List<Map<String, Object>> getRoleAuth(int roleId);
}