package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.DoctorDao;
import com.yyece.his.entity.Doctor;
import com.yyece.his.entity.Role;
import com.yyece.his.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Doctor)表服务实现类
 *
 * @author makejava
 * @since 2020-03-11 22:57:58
 */
@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, Doctor> implements DoctorService {
    @Autowired
    DoctorDao doctorDao;

    public Doctor findDoctorByAccount(String account) {
        return doctorDao.findDoctorByAccount(account);
    }

    public List<Map<String, Object>> getDoctorRoles(int doctorId){
        return doctorDao.getDoctorRoles(doctorId);
    }

    public List<Map<String, Object>> getRoleAuth(int roleId){
        return doctorDao.getRoleAuth(roleId);
    }
}