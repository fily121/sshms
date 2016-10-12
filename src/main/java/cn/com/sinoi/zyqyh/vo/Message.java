package cn.com.sinoi.zyqyh.vo;

import java.util.Date;

public class Message {

    private String id;

    private String fromuser;

    private String tosgdid;

    private String type;

    private Date time;

    private String attachmentid;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromuser() {
        return fromuser;
    }

    public void setFromuser(String fromuser) {
        this.fromuser = fromuser;
    }

    public String getTosgdid() {
        return tosgdid;
    }

    public void setTosgdid(String tosgdid) {
        this.tosgdid = tosgdid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAttachmentid() {
        return attachmentid;
    }

    public void setAttachmentid(String attachmentid) {
        this.attachmentid = attachmentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
