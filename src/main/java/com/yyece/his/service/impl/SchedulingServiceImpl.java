package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.SchedulingDao;
import com.yyece.his.entity.Scheduling;
import com.yyece.his.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Scheduling)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 02:53:27
 */
@Service("schedulingService")
public class SchedulingServiceImpl extends ServiceImpl<SchedulingDao, Scheduling> implements SchedulingService {
    @Autowired
    SchedulingDao schedulingDao;
    @Override
    public boolean saveScheduling(Map<String, Object> map) {
        return schedulingDao.saveScheduling(map);
    }

    @Override
    public boolean modifyScheduling(Map<String, Object> map) {
        return schedulingDao.modifyScheduling(map);
    }

    @Override
    public boolean deleteBySchedulingId(Map<String, Object> map) {
        return schedulingDao.deleteBySchedulingId(map);
    }

    @Override
    public List<Scheduling> querySchedulingByParam(Scheduling scheduling) {
        return schedulingDao.querySchedulingByParam(scheduling);
    }
}