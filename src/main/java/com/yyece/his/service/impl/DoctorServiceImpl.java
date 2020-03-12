package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.DoctorDao;
import com.yyece.his.entity.Doctor;
import com.yyece.his.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}