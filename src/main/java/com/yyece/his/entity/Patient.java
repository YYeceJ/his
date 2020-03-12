package com.yyece.his.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * (Patient)表实体类
 *
 * @author makejava
 * @since 2020-03-10 22:24:52
 */
@SuppressWarnings("serial")
public class Patient extends Model<Patient> {
    
    private Integer patientid;
    
    private String phone;
    
    private String patientname;
    
    private String password;
    //性别，1表示女，2表示男
    private Integer gender;
    //出生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    //备注
    private String note;
    //是否删除，0表示未删除，1表示已删除是
    private Integer isdeleted;
    //第一次挂号
    private Date jointime;


    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.patientid;
    }
    }