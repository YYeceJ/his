package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2020-03-12 23:47:20
 */
@SuppressWarnings("serial")
public class Role extends Model<Role> {
    
    private Integer roleid;
    
    private String rolename;
    
    private String creatorname;
    
    private Integer creactorid;
    
    private Integer isdeleted;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public Integer getCreactorid() {
        return creactorid;
    }

    public void setCreactorid(Integer creactorid) {
        this.creactorid = creactorid;
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
        return this.roleid;
    }
    }