package com.skynet.collection.vo;

import java.util.Date;

public class CollectionInfo {
	
    private String cId;

    private String areaId;

    private String raceId;

    private String name;

    private Integer sex;

    private String idCardNo;

    private Date idCardStartDate;

    private Date idCardEndDate;

    private String anmeldenAddress;

    private String anmeldenDetailAddress;

    private String residentialAddress;

    private String residentialDatailAddress;

    private String medicareCardNo;

    private String ruralCooperativeCardNo;

    private String orgId;

    private String createUser;

    private Integer isAudited;

    private Date createDate;

    private Date updateDate;

    private String createUser2;

    private String ext3;

    private String ext2;

    private String ext1;

    private String remark;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId == null ? null : raceId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public Date getIdCardStartDate() {
        return idCardStartDate;
    }

    public void setIdCardStartDate(Date idCardStartDate) {
        this.idCardStartDate = idCardStartDate;
    }

    public Date getIdCardEndDate() {
        return idCardEndDate;
    }

    public void setIdCardEndDate(Date idCardEndDate) {
        this.idCardEndDate = idCardEndDate;
    }

    public String getAnmeldenAddress() {
        return anmeldenAddress;
    }

    public void setAnmeldenAddress(String anmeldenAddress) {
        this.anmeldenAddress = anmeldenAddress == null ? null : anmeldenAddress.trim();
    }

    public String getAnmeldenDetailAddress() {
        return anmeldenDetailAddress;
    }

    public void setAnmeldenDetailAddress(String anmeldenDetailAddress) {
        this.anmeldenDetailAddress = anmeldenDetailAddress == null ? null : anmeldenDetailAddress.trim();
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress == null ? null : residentialAddress.trim();
    }

    public String getResidentialDatailAddress() {
        return residentialDatailAddress;
    }

    public void setResidentialDatailAddress(String residentialDatailAddress) {
        this.residentialDatailAddress = residentialDatailAddress == null ? null : residentialDatailAddress.trim();
    }

    public String getMedicareCardNo() {
        return medicareCardNo;
    }

    public void setMedicareCardNo(String medicareCardNo) {
        this.medicareCardNo = medicareCardNo == null ? null : medicareCardNo.trim();
    }

    public String getRuralCooperativeCardNo() {
        return ruralCooperativeCardNo;
    }

    public void setRuralCooperativeCardNo(String ruralCooperativeCardNo) {
        this.ruralCooperativeCardNo = ruralCooperativeCardNo == null ? null : ruralCooperativeCardNo.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Integer getIsAudited() {
        return isAudited;
    }

    public void setIsAudited(Integer isAudited) {
        this.isAudited = isAudited;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateUser2() {
        return createUser2;
    }

    public void setCreateUser2(String createUser2) {
        this.createUser2 = createUser2 == null ? null : createUser2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}