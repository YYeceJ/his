package com.yyece.his.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * (Doctor)表实体类
 *
 * @author makejava
 * @since 2020-03-11 22:57:56
 */
@SuppressWarnings("serial")
public class Doctor extends Model<Doctor> {
    private Integer doctorid;

    private String account;

    private String doctorname;

    private String password;
    //擅长疾病
    private String skilledfield;

    private Integer departmentid;

    private String departmentname;

    private Integer titleid;
    //职称
    private String doctortitle;
    //执业经历
    private String practiceexperience;
    //头像
    private String head;
    //是否删除，0表示未删除，1表示已删除
    private Integer isdeleted;


    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkilledfield() {
        return skilledfield;
    }

    public void setSkilledfield(String skilledfield) {
        this.skilledfield = skilledfield;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public String getDoctortitle() {
        return doctortitle;
    }

    public void setDoctortitle(String doctortitle) {
        this.doctortitle = doctortitle;
    }

    public String getPracticeexperience() {
        return practiceexperience;
    }

    public void setPracticeexperience(String practiceexperience) {
        this.practiceexperience = practiceexperience;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
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
        return this.doctorid;
    }
}