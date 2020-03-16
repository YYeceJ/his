package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.PatientDao;
import com.yyece.his.entity.Patient;
import com.yyece.his.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2020-03-16 10:57:58
 */
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, Patient> implements PatientService {

    @Autowired
    PatientDao patientDao;
    @Override
    public Patient findPatientByPhone(String phone) {
        return patientDao.findPatientByPhone(phone);
    }

    @Override
    public boolean modify(Map<String, Object> map) {
        return patientDao.modify(map);
    }

    @Override
    public boolean savePatient(Map<String, Object> map) {
        return patientDao.savePatient(map);
    }


}