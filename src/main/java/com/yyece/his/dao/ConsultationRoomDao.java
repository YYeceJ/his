package com.yyece.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyece.his.entity.ConsultationRoom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * 诊室(ConsultationRoom)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-17 12:41:46
 */
public interface ConsultationRoomDao extends BaseMapper<ConsultationRoom> {
    @Update("UPDATE consultation_room SET consultingRoomName = #{consultingRoomName} WHERE roomId = #{roomId}")
    boolean modify(Map<String, Object> map);

    @Delete("DELETE FROM consultation_room WHERE roomId =#{roomId}")
    boolean deleteByRoomId(Map<String, Object> map);

    @Insert("INSERT into consultation_room (consultingRoomName) VALUES (#{consultingRoomName})")
    boolean saveRoom(Map<String, Object> map);

}