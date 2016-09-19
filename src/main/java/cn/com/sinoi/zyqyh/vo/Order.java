package cn.com.sinoi.zyqyh.vo;

import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMDHMS;
import java.util.Date;

public class Order {

    private String orderId;

    private String orderName;

    private Date createDate;

    private Date updateDate;

    private String createUser;

    private String remark;

    private String sgdid;

    private String attachmentId;

    private String orderNumber;

    private String orderDetail;

    private String startTime;

    private String endTime;

    private String lxNumber;

    private String problem;

    public String getFormattedCreateDate() {
        if (createDate != null) {
            return FORMATTER_YMDHMS.format(createDate);
        } else {
            return "";
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSgdid() {
        return sgdid;
    }

    public void setSgdid(String sgdid) {
        this.sgdid = sgdid == null ? null : sgdid.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail == null ? null : orderDetail.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLxNumber() {
        return lxNumber;
    }

    public void setLxNumber(String lxNumber) {
        this.lxNumber = lxNumber == null ? null : lxNumber.trim();
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem == null ? null : problem.trim();
    }
}
