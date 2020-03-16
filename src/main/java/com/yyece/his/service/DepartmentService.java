package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.Department;

import java.util.Map;

/**
 * 科室表(Department)表服务接口
 *
 * @author makejava
 * @since 2020-03-10 11:35:11
 */
public interface DepartmentService extends IService<Department> {

    boolean modifyDepartment(Map<String, Object> map);

    boolean deleteByDepartmentId(Map<String, Object> map);

    boolean saveDepartment(Map<String, Object> map);
}