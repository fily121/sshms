package cn.com.sinoi.zyqyh.vo;

import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMDHMS;
import java.util.Date;

public class Gzzd {

    private String id;

    private String name;

    private String detail;

    private String attachmentid;

    private String lastmodifyuserid;

    private String formattedTime;

    public String getFormattedTime() {
        if (lastmodifytime != null) {
            return FORMATTER_YMDHMS.format(lastmodifytime);
        } else {
            return "";
        }
    }

    private Date lastmodifytime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getAttachmentid() {
        return attachmentid;
    }

    public void setAttachmentid(String attachmentid) {
        this.attachmentid = attachmentid == null ? null : attachmentid.trim();
    }

    public String getLastmodifyuserid() {
        return lastmodifyuserid;
    }

    public void setLastmodifyuserid(String lastmodifyuserid) {
        this.lastmodifyuserid = lastmodifyuserid == null ? null : lastmodifyuserid.trim();
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }
}
