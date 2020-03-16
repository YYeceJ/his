package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Patient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * (Patient)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-16 10:57:58
 */
public interface PatientDao extends BaseMapper<Patient> {

    @Select("SELECT *  FROM patient WHERE phone = #{phone}")
    Patient findPatientByPhone(String phone);

    @Update("UPDATE patient SET phone=#{phone},patientName =#{patientName}," +
            "gender=#{gender},birthDate=#{birthDate},password=#{password}," +
            "WHERE patientId = #{patientId}")
    boolean modify(Map<String, Object> map);

    @Insert("INSERT INTO patient (phone, password)" +
            "VALUES(#{phone},#{password})")
    boolean savePatient(Map<String, Object> map);


}