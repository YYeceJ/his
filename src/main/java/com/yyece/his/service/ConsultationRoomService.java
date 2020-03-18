package com.yyece.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyece.his.entity.ConsultationRoom;

import java.util.Map;

/**
 * 诊室(ConsultationRoom)表服务接口
 *
 * @author makejava
 * @since 2020-03-17 12:41:46
 */
public interface ConsultationRoomService extends IService<ConsultationRoom> {
    boolean modify(Map<String, Object> map);

    boolean deleteByRoomId(Map<String, Object> map);

    boolean saveRoom(Map<String, Object> map);
}