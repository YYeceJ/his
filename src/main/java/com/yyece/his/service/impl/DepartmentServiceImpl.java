package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.DepartmentDao;
import com.yyece.his.entity.Department;
import com.yyece.his.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * 科室表(Department)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 11:35:12
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DepartmentService {

}