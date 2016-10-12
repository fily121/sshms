package cn.com.sinoi.zyqyh.vo;

import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMD;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class User {

    private String userId;

    private String userName;

    private String userPwd;

    private Integer isGuest;

    private Integer isLocked;

    private String roleId;

    private String orgId;

    private Date createDate;

    private Date updateDate;

    private String createUser;

    private String openid;

    private String wechatno;

    private String name;

    private String remark;

    private String gender;

    private Date birthday;

    public String getBbirthdayString() {
        if (birthday != null) {
            return FORMATTER_YMD.format(birthday);
        } else {
            return "";
        }
    }

    private String idNo;

    private String education;

    private String phone;

    private String email;

    private String major;

    private String gangwei;

    private String yongglx;

    private Integer gongzsj;

    private String gongzds;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bendsgzkssj;

    public String getBendsgzkssjString() {
        if (bendsgzkssj != null) {
            return FORMATTER_YMD.format(bendsgzkssj);
        } else {
            return "";
        }
    }
    private String zhengsmc;

    private String zizNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zizTime;

    public String getZizTimeString() {
        if (zizTime != null) {
            return FORMATTER_YMD.format(zizTime);
        } else {
            return "";
        }
    }

    private String zizOrg;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date zizEndtime;

    public String getZizEndtimeString() {
        if (zizEndtime != null) {
            return FORMATTER_YMD.format(zizEndtime);
        } else {
            return "";
        }
    }
    private String baox;

    private String other;

    private String verifyCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Integer isGuest) {
        this.isGuest = isGuest;
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getWechatno() {
        return wechatno;
    }

    public void setWechatno(String wechatno) {
        this.wechatno = wechatno == null ? null : wechatno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getGangwei() {
        return gangwei;
    }

    public void setGangwei(String gangwei) {
        this.gangwei = gangwei == null ? null : gangwei.trim();
    }

    public String getYongglx() {
        return yongglx;
    }

    public void setYongglx(String yongglx) {
        this.yongglx = yongglx == null ? null : yongglx.trim();
    }

    public Integer getGongzsj() {
        return gongzsj;
    }

    public void setGongzsj(Integer gongzsj) {
        this.gongzsj = gongzsj;
    }

    public String getGongzds() {
        return gongzds;
    }

    public void setGongzds(String gongzds) {
        this.gongzds = gongzds == null ? null : gongzds.trim();
    }

    public Date getBendsgzkssj() {
        return bendsgzkssj;
    }

    public void setBendsgzkssj(Date bendsgzkssj) {
        this.bendsgzkssj = bendsgzkssj;
    }

    public String getZhengsmc() {
        return zhengsmc;
    }

    public void setZhengsmc(String zhengsmc) {
        this.zhengsmc = zhengsmc == null ? null : zhengsmc.trim();
    }

    public String getZizNo() {
        return zizNo;
    }

    public void setZizNo(String zizNo) {
        this.zizNo = zizNo == null ? null : zizNo.trim();
    }

    public Date getZizTime() {
        return zizTime;
    }

    public void setZizTime(Date zizTime) {
        this.zizTime = zizTime;
    }

    public String getZizOrg() {
        return zizOrg;
    }

    public void setZizOrg(String zizOrg) {
        this.zizOrg = zizOrg == null ? null : zizOrg.trim();
    }

    public Date getZizEndtime() {
        return zizEndtime;
    }

    public void setZizEndtime(Date zizEndtime) {
        this.zizEndtime = zizEndtime;
    }

    public String getBaox() {
        return baox;
    }

    public void setBaox(String baox) {
        this.baox = baox == null ? null : baox.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
