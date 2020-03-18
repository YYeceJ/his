package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.ConsultationRoomDao;
import com.yyece.his.entity.ConsultationRoom;
import com.yyece.his.service.ConsultationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 诊室(ConsultationRoom)表服务实现类
 *
 * @author makejava
 * @since 2020-03-17 12:41:47
 */
@Service("consultationRoomService")
public class ConsultationRoomServiceImpl extends ServiceImpl<ConsultationRoomDao, ConsultationRoom> implements ConsultationRoomService {

    @Autowired
    ConsultationRoomDao consultationRoomDao;
    @Override
    public boolean modify(Map<String, Object> map) {
        return consultationRoomDao.modify(map);
    }

    @Override
    public boolean deleteByRoomId(Map<String, Object> map) {
        return consultationRoomDao.deleteByRoomId(map);
    }

    @Override
    public boolean saveRoom(Map<String, Object> map) {
        return consultationRoomDao.saveRoom(map);
    }
}