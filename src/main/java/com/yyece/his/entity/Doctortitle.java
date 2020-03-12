package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Doctortitle)表实体类
 *
 * @author makejava
 * @since 2020-03-10 11:35:38
 */
@SuppressWarnings("serial")
public class Doctortitle extends Model<Doctortitle> {
    
    private Integer titleid;
    
    private String titlename;


    public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.titleid;
    }
    }