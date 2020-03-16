package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Scheduling;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * (Scheduling)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-15 02:53:26
 */
public interface SchedulingDao extends BaseMapper<Scheduling> {
    @Insert("INSERT INTO scheduling (departmentId, departmentName,doctorId,doctorName,cost,roomId,roomName,creatorId,creatorName,date,startTime,endTime,patientId,patientName" +
            ",status,chiefComplaint,examinationResult,diagnosticResult,doctorOpinion,note)" +
            "VALUES(#{departmentId},#{departmentName},#{doctorId},#{doctorName},#{cost},#{roomId},#{roomName},#{creatorId}," +
            "#{creatorName},#{date},#{startTime},#{endTime},0,'',0,'','','','','')")
    boolean saveScheduling(Map<String, Object> map);


    @Update("<script> UPDATE scheduling SET " +
            "<if test='departmentId != null'>  departmentId = #{departmentId}, </if> " +
            "<if test='departmentName != null'>  departmentName = #{departmentName}, </if> " +
            "<if test='doctorId != null'>  doctorId = #{doctorId}, </if> " +
            "<if test='doctorName != null'>  doctorName = #{doctorName}, </if> " +
            "<if test='cost != null'>  cost = #{cost}, </if> " +
            "<if test='roomId != null'>  roomId = #{roomId}, </if> " +
            "<if test='roomName != null'>  roomName = #{roomName}, </if> " +
            "<if test='date != null'>  date = #{date}, </if> " +
            "<if test='startTime != null'>  startTime = #{startTime}, </if> " +
            "<if test='endTime != null'>  endTime = #{endTime}, </if> " +
            "<if test='patientId != null'>  patientId = #{patientId}, </if> " +
            "<if test='patientName != null'>  patientName = #{patientName}, </if> " +
            "<if test='status != null'>  status = #{status}, </if> " +
            "<if test='chiefComplaint != null'>  chiefComplaint = #{chiefComplaint}, </if> " +
            "<if test='examinationResult != null'>  examinationResult = #{examinationResult}, </if> " +
            "<if test='diagnosticResult != null'>  diagnosticResult = #{diagnosticResult}, </if> " +
            "<if test='doctorOpinion != null'>  doctorOpinion = #{doctorOpinion}, </if> " +
            "note = '1' " +
            "WHERE schedulingId = #{schedulingId} </script>")
    boolean modifyScheduling(Map<String, Object> map);

    @Delete("delete from scheduling WHERE schedulingId = #{schedulingId}")
    boolean deleteBySchedulingId(Map<String, Object> map);

    @Select("<script> select * FROM scheduling  where 1=1" +
            "<when test='departmentid != null'> and departmentId = #{departmentid} </when> " +
            "<when test='roomid != null'> and roomId = #{roomid} </when> " +
            "<when test='doctorid != null'> and doctorId = #{doctorid} </when> " +
            "<when test='patientid != null'> and patientId = #{patientid} </when> " +
            "<when test='status != null'> and status = #{status} </when> " +
            "<when test='doctorname != null'> and doctorName like '% #{doctorname} %' </when> " +
            "<when test='date != null'> and date = #{date} </when> " +
            "</script>")
    List<Scheduling> querySchedulingByParam(Scheduling scheduling);
}