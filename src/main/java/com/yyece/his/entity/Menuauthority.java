package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Menuauthority)表实体类
 *
 * @author makejava
 * @since 2020-03-11 20:02:18
 */
@SuppressWarnings("serial")
public class Menuauthority extends Model<Menuauthority> {
    
    private Integer menuauthorityid;
    
    private String menuauthorityname;


    public Integer getMenuauthorityid() {
        return menuauthorityid;
    }

    public void setMenuauthorityid(Integer menuauthorityid) {
        this.menuauthorityid = menuauthorityid;
    }

    public String getMenuauthorityname() {
        return menuauthorityname;
    }

    public void setMenuauthorityname(String menuauthorityname) {
        this.menuauthorityname = menuauthorityname;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.menuauthorityid;
    }
    }