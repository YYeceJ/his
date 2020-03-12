package com.yyece.his.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2020-03-11 23:30:16
 */
@SuppressWarnings("serial")
public class Role extends Model<Role> {
    private Integer roleid;
    
    private String rolename;
    
    private Integer creactorid;
    
    private Date creattime;
    
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

    public Integer getCreactorid() {
        return creactorid;
    }

    public void setCreactorid(Integer creactorid) {
        this.creactorid = creactorid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
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