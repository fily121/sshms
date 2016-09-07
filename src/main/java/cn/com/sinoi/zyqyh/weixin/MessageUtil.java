package cn.com.sinoi.zyqyh.weixin;

import cn.com.sinoi.zyqyh.weixin.bean.TemplateData;
import cn.com.sinoi.zyqyh.weixin.bean.WxTemplate;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

/**
 * 消息工具类
 *
 * @author ivhhs
 * @date 2014.10.16
 */
public class MessageUtil {

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";
    /**
     * 事件类型：视频
     */
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    /**
     * 事件类型：扫二维码
     */
    public static final String EVENT_TYPE_SCAN = "scan";
    public static final String MB_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    public static String getBangdingMessage(String openId, String first, String keyword1, String keyword2) {
        String templateId = "0udqqKzvloebLJ-fMgVlQWRR8ya_SziBIWn3iOKbHJs";
        WxTemplate temp = new WxTemplate();
        temp.setUrl("");
        temp.setTouser(openId);
        temp.setTopcolor("#000000");
        temp.setTemplate_id(templateId);
        Map<String, TemplateData> m = new HashMap<>();
        TemplateData firstTemp = new TemplateData();
        firstTemp.setColor("#000000");
        firstTemp.setValue(first);
        m.put("first", firstTemp);
        TemplateData name = new TemplateData();
        name.setColor("#000000");
        name.setValue(keyword1);
        m.put("keyword1", name);
        TemplateData orderNo = new TemplateData();
        orderNo.setColor("#000000");
        orderNo.setValue(keyword2);
        m.put("keyword2", orderNo);
        temp.setData(m);
        String jsonString = JSONObject.fromObject(temp).toString();
        return jsonString;
    }

    public static String getYichangMessage(String openId, String 操作隐患提醒, String 操作提醒, String msg) {
        String templateId = "0-h-oQhOuVh5fpPkMvALNti9DtJnZpEZEc5eNWE_ThY";
        WxTemplate temp = new WxTemplate();
        temp.setUrl("");
        temp.setTouser(openId);
        temp.setTopcolor("#000000");
        temp.setTemplate_id(templateId);
        Map<String, TemplateData> m = new HashMap<>();
        TemplateData firstTemp = new TemplateData();
        firstTemp.setColor("#000000");
        firstTemp.setValue(操作隐患提醒);
        m.put("first", firstTemp);
        TemplateData name = new TemplateData();
        name.setColor("#000000");
        name.setValue(操作提醒);
        m.put("keyword1", name);
        TemplateData orderNo = new TemplateData();
        orderNo.setColor("#000000");
        orderNo.setValue(操作提醒);
        m.put("keyword2", orderNo);
        TemplateData message = new TemplateData();
        orderNo.setColor("#000000");
        orderNo.setValue(msg);
        m.put("remark", message);
        temp.setData(m);
        String jsonString = JSONObject.fromObject(temp).toString();
        return jsonString;
    }

    public static String getOrderMessage(String openId, String first, String keyword1, String keyword2, String keyword3, String remark, String url) {
        String templateId = "8kDiD9vSDYwXDWvUGJuJKL_p-QBsKrVLWci7MTDBcgY";
        WxTemplate temp = new WxTemplate();
        temp.setUrl(url);
        temp.setTouser(openId);
        temp.setTopcolor("#000000");
        temp.setTemplate_id(templateId);
        Map<String, TemplateData> m = new HashMap<>();
        TemplateData firstTemp = new TemplateData();
        firstTemp.setColor("#000000");
        firstTemp.setValue(first);
        m.put("first", firstTemp);
        TemplateData name = new TemplateData();
        name.setColor("#000000");
        name.setValue(keyword1);
        m.put("keyword1", name);
        TemplateData orderNo = new TemplateData();
        orderNo.setColor("#000000");
        orderNo.setValue(keyword2);
        m.put("keyword2", orderNo);
        TemplateData key3 = new TemplateData();
        key3.setColor("#000000");
        key3.setValue(keyword3);
        m.put("keyword3", key3);
        TemplateData message = new TemplateData();
        message.setColor("#000000");
        message.setValue(remark);
        m.put("remark", message);
        temp.setData(m);
        String jsonString = JSONObject.fromObject(temp).toString();
        return jsonString;
    }
}
