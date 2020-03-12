package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.RoleDao;
import com.yyece.his.entity.Role;
import com.yyece.his.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-03-12 23:47:21
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}