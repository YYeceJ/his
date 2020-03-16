package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.Patient;

import java.util.Map;

/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2020-03-16 10:57:58
 */
public interface PatientService extends IService<Patient> {
    Patient findPatientByPhone(String phone);
    boolean modify(Map<String, Object> map);
    boolean savePatient(Map<String, Object> map);
}