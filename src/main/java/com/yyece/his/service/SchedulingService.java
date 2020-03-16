package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.Scheduling;

import java.util.List;
import java.util.Map;

/**
 * (Scheduling)表服务接口
 *
 * @author makejava
 * @since 2020-03-15 02:53:26
 */
public interface SchedulingService extends IService<Scheduling> {
    boolean saveScheduling(Map<String, Object> map);

    boolean modifyScheduling(Map<String, Object> map);

    boolean deleteBySchedulingId(Map<String, Object> map);

    List<Scheduling> querySchedulingByParam(Scheduling scheduling);
}