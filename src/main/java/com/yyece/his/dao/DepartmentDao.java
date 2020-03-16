package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * 科室表(Department)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-10 11:35:11
 */
public interface DepartmentDao extends BaseMapper<Department> {
    @Update("UPDATE department SET name=#{name},introduction =#{introduction} WHERE departmentId = #{departmentId}")
    boolean modifyDepartment(Map<String, Object> map);

    @Update("UPDATE department SET isDeleted=1 WHERE departmentId = #{departmentId}")
    boolean deleteByDepartmentId(Map<String, Object> map);

    @Insert("INSERT INTO department (name, introduction,isDeleted,parentId,note,doctorId)" +
            "VALUES(#{name},#{introduction},0,1,'',1)")
    boolean saveDepartment(Map<String, Object> map);
}