package com.yyece.his.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * (Scheduling)表实体类
 *
 * @author makejava
 * @since 2020-03-11 06:54:48
 */
@SuppressWarnings("serial")
public class Scheduling extends Model<Scheduling> {
    
    private Integer schedulingid;
    
    private Integer departmentid;
    
    private String departmentname;
    
    private Integer doctorid;
    
    private String doctorname;
    
    private String roomname;
    
    private Integer roomid;
    //费用
    private Double cost;
    //创建人Id
    private Integer creatorid;
    
    private String creatorname;
    
    private Integer isdeleted;
    //日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    private Object starttime;
    
    private Object endtime;
    
    private Integer patientid;
    
    private String patientname;
    //0-未预约，1-已预约，2-就诊中，3-已完成
    private Integer status;
    //病人主诉
    private String chiefcomplaint;
    //检查结果
    private String examinationresult;
    //诊断结果
    private String diagnosticresult;
    //医生意见
    private String doctoropinion;
    //备注
    private String note;


    public Integer getSchedulingid() {
        return schedulingid;
    }

    public void setSchedulingid(Integer schedulingid) {
        this.schedulingid = schedulingid;
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

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getStarttime() {
        return starttime;
    }

    public void setStarttime(Object starttime) {
        this.starttime = starttime;
    }

    public Object getEndtime() {
        return endtime;
    }

    public void setEndtime(Object endtime) {
        this.endtime = endtime;
    }

    public Integer getPatientid() {
        return patientid;
    }

    public void setPatientid(Integer patientid) {
        this.patientid = patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getChiefcomplaint() {
        return chiefcomplaint;
    }

    public void setChiefcomplaint(String chiefcomplaint) {
        this.chiefcomplaint = chiefcomplaint;
    }

    public String getExaminationresult() {
        return examinationresult;
    }

    public void setExaminationresult(String examinationresult) {
        this.examinationresult = examinationresult;
    }

    public String getDiagnosticresult() {
        return diagnosticresult;
    }

    public void setDiagnosticresult(String diagnosticresult) {
        this.diagnosticresult = diagnosticresult;
    }

    public String getDoctoropinion() {
        return doctoropinion;
    }

    public void setDoctoropinion(String doctoropinion) {
        this.doctoropinion = doctoropinion;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.schedulingid;
    }
    }