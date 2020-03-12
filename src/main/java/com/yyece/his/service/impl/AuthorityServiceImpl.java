package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.AuthorityDao;
import com.yyece.his.entity.Authority;
import com.yyece.his.service.AuthorityService;
import org.springframework.stereotype.Service;

/**
 * (Authority)表服务实现类
 *
 * @author makejava
 * @since 2020-03-12 23:47:20
 */
@Service("authorityService")
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao, Authority> implements AuthorityService {

}