package com.yyece.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyece.his.dao.ConsultationRoomDao;
import com.yyece.his.entity.ConsultationRoom;
import com.yyece.his.service.ConsultationRoomService;
import org.springframework.stereotype.Service;

/**
 * 诊室(ConsultationRoom)表服务实现类
 *
 * @author makejava
 * @since 2020-03-10 22:55:44
 */
@Service("consultationRoomService")
public class ConsultationRoomServiceImpl extends ServiceImpl<ConsultationRoomDao, ConsultationRoom> implements ConsultationRoomService {

}