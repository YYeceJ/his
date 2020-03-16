package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.DepartmentDao;
import com.yyece.his.dao.DoctorDao;
import com.yyece.his.entity.Department;
import com.yyece.his.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 科室表(Department)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 11:35:12
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao ;
    public boolean modifyDepartment(Map<String, Object> map) {
        return departmentDao.modifyDepartment(map);
    }

    @Override
    public boolean deleteByDepartmentId(Map<String, Object> map) {
        return departmentDao.deleteByDepartmentId(map);
    }

    @Override
    public boolean saveDepartment(Map<String, Object> map) {
        return departmentDao.saveDepartment(map);
    }


}