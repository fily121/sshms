package cn.com.sinoi.zyqyh.vo;

import java.util.Date;

@lombok.Getter
@lombok.Setter
public class Message {

    private String id;

    private String fromuser;

    private String tosgdid;

    private String type;

    private Date time;

    private String attachmentid;

    private String content;
}
