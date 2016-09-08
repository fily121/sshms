package cn.com.sinoi.zyqyh.vo;

import java.util.Date;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMDHMS;

public class Project {

    private String projectId;

    private String projectName;

    private String attachmentId;

    private Date createTime;

    private String projectDetail;

    public String getFormattedCreateDate() {
        if (createTime != null) {
            return FORMATTER_YMDHMS.format(createTime);
        } else {
            return "";
        }
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail == null ? null : projectDetail.trim();
    }
}
