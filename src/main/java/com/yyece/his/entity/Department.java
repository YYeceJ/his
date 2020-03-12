package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;


/**
 * 科室表(Department)表实体类
 *
 * @author makejava
 * @since 2020-03-10 11:35:11
 */
@SuppressWarnings("serial")
public class Department extends Model<Department> {
    
    private Integer departmentid;

    private String name;
    //父级科室的id，如果为第一级则为0
    private Integer parentid;
    //简介
    private String introduction;
    
    private Integer isdeleted;
    //备注
    private String note;
    
    private Integer doctorid;


    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.departmentid;
    }
    }