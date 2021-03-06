package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 诊室(ConsultationRoom)表实体类
 *
 * @author makejava
 * @since 2020-03-17 12:41:45
 */
@SuppressWarnings("serial")
public class ConsultationRoom extends Model<ConsultationRoom> {
    
    private Integer roomid;
    
    private String consultingroomname;
    
    private Integer isdeleted;


    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getConsultingroomname() {
        return consultingroomname;
    }

    public void setConsultingroomname(String consultingroomname) {
        this.consultingroomname = consultingroomname;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.roomid;
    }
    }