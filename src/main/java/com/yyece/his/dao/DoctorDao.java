package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Doctor;
import com.yyece.his.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * (Doctor)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-11 22:57:57
 */
public interface DoctorDao extends BaseMapper<Doctor> {
    /*
     * 根据account查询doctor*/
    @Select("SELECT * FROM doctor WHERE account =  #{account} and isDeleted = 0")
    Doctor findDoctorByAccount(@Param("account") String account);

    @Select("SELECT r.roleId,r.roleName FROM doctor d ,role r ,doctor_role_relation dr WHERE d.doctorId = dr.doctorId and dr.roleId = r.roleId and d.doctorId = #{doctorId} and d.isDeleted = 0")
    List<Map<String, Object>> getDoctorRoles(@Param("doctorId") int doctorId);

    @Select("SELECT a.authorityId,a.name,a.code FROM role r ,authority a ,role_authority_relation ra WHERE r.roleId = ra.roleId and ra.authorityId =  a.authorityId and r.roleId =#{roleId}")
    List<Map<String, Object>> getRoleAuth(@Param("roleId") int roleId);

    @Update("UPDATE doctor SET doctorName=#{doctorName},skilledField =#{skilledField},departmentId=#{departmentId},departmentName=#{departmentName},doctorTitle=#{doctorTitle},practiceExperience=#{practiceExperience} WHERE doctorId = #{doctorId}")
    boolean modify(Map<String, Object> map);

    @Update("UPDATE doctor SET isDeleted=1 WHERE doctorId = #{doctorId}")
    boolean deleteByDoctorId(Map<String, Object> map);

    @Insert("INSERT INTO doctor (account, doctorName,password,skilledField,departmentId,departmentName,doctorTitle,practiceExperience,isDeleted)" +
            "VALUES(#{account},#{doctorName},'welcome123',#{skilledField},#{departmentId},#{departmentName},#{doctorTitle},#{practiceExperience},0)")
    boolean saveDoctor(Map<String, Object> map);

    @Insert("INSERT into doctor_role_relation (roleId,doctorId) VALUES (3,#{doctorId})")
    boolean setDoctorRole(int doctorId);
}
