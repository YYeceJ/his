package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Authority)表实体类
 *
 * @author makejava
 * @since 2020-03-12 23:47:18
 */
@SuppressWarnings("serial")
public class Authority extends Model<Authority> {
    
    private Integer authorityid;
    
    private String name;
    
    private Integer creactorid;
    
    private String creatorname;
    
    private String code;
    
    private Integer isdelete;


    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreactorid() {
        return creactorid;
    }

    public void setCreactorid(Integer creactorid) {
        this.creactorid = creactorid;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.authorityid;
    }
    }