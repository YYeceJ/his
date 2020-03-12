package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.SchedulingDao;
import com.yyece.his.entity.Scheduling;
import com.yyece.his.service.SchedulingService;
import org.springframework.stereotype.Service;

/**
 * (Scheduling)表服务实现类
 *
 * @author makejava
 * @since 2020-03-11 06:54:48
 */
@Service("schedulingService")
public class SchedulingServiceImpl extends ServiceImpl<SchedulingDao, Scheduling> implements SchedulingService {

}