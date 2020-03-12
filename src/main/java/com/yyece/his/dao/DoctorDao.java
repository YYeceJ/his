package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Doctor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (Doctor)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-11 22:57:57
 */
public interface DoctorDao extends BaseMapper<Doctor> {

    /*
     * 根据account查询doctor*/
    @Select("SELECT * FROM doctor WHERE account =  #{account}")
    Doctor findDoctorByAccount(@Param("account") String account);
}