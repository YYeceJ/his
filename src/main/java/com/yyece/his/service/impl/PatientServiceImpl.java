package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.PatientDao;
import com.yyece.his.entity.Patient;
import com.yyece.his.service.PatientService;
import org.springframework.stereotype.Service;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 22:24:52
 */
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientDao, Patient> implements PatientService {

}