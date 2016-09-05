package cn.com.sinoi.zyqyh.weixin.bean;

/**
 * 文本消息
 *
 * @author ivhhs
 * @date 2014.10.16
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
