package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.Doctor;

/**
 * (Doctor)表服务接口
 *
 * @author makejava
 * @since 2020-03-11 22:57:58
 */
public interface DoctorService extends IService<Doctor> {
    Doctor findDoctorByAccount(String account);
}