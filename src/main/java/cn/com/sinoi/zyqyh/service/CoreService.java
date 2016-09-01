package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.wechat.msg.MessageUtil;
import cn.com.sinoi.wechat.msg.Resp.TextMessage;
import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.User;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 核心Service类
 *
 * @author ivhhs
 * @date 2014.10.16
 */
@Service("wechatService")
public class CoreService {

    @Autowired
    IUserService userService;
    @Autowired
    IMessageService messageService;

    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return xml
     */
    public String processRequest(String request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "消息已接收。";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            Date date = new Date();
            textMessage.setCreateTime(date.getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                // 消息类型
                String content = requestMap.get("Content");
                if (StringUtils.isNotEmpty(content) && content.matches("^绑定微信号\\(.*")) {
                    String 微信号 = content.substring(6, content.indexOf(")"));
                    User user = userService.selectByWechatNo(微信号);
                    if (user == null) {
                        respContent = "微信号没有录入到系统，请联系管理员。";
                    } else {
                        user.setOpenid(fromUserName);
                        userService.save(user);
                        respContent = "微信号录入成功。";
                    }
                } else {
                    User user = userService.selectByOpenId(fromUserName);
                    if (user == null) {
                        respContent = "未绑定微信号，请回复以下消息到服务号来绑定：绑定微信号(您的微信号)。";
                    } else {
                        Message message = new Message();
                        message.setContent(content);
                        message.setFromuser(user.getUserId());
                        message.setId(java.util.UUID.randomUUID().toString());
                        message.setTime(date);
                        message.setTosgdid(user.getOrgId());
                        messageService.insert(message);
                    }
                }

            } // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                String picUrl = requestMap.get("PicUrl");
                String mediaId = requestMap.get("MediaId");
                User user = userService.selectByOpenId(fromUserName);
                if (user == null) {
                    respContent = "未绑定微信号，请回复以下消息到服务号来绑定：绑定微信号(您的微信号)。";
                } else {
                    Message message = new Message();
                    message.setContent("<img src=" + picUrl + "/>");
                    message.setFromuser(user.getUserId());
                    message.setId(java.util.UUID.randomUUID().toString());
                    message.setTime(date);
                    message.setTosgdid(user.getOrgId());
                    messageService.insert(message);
                }
            } // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            } // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            } // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            } // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            } // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                } // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                } // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                } // 上报地理位置
                else if (eventType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                } // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    String eventKey = requestMap.get("EventKey");
                    System.out.println("EventKey=" + eventKey);
                    respContent = "点击的菜单KEY:" + eventKey;
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

}
