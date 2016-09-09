package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.definition.FilePathEnum;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.service.IUserService;
import cn.com.sinoi.zyqyh.service.IWechatService;
import cn.com.sinoi.zyqyh.utils.DateUtil;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_HMS;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMD;
import static cn.com.sinoi.zyqyh.utils.DateUtil.FORMATTER_YMDHMS;
import cn.com.sinoi.zyqyh.utils.UrlDownloadFile;
import cn.com.sinoi.zyqyh.vo.Attachment;
import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.User;
import cn.com.sinoi.zyqyh.weixin.MessageUtil;
import cn.com.sinoi.zyqyh.weixin.WeixinUtil;
import cn.com.sinoi.zyqyh.weixin.WxMpServiceInstance;
import cn.com.sinoi.zyqyh.weixin.WxMpXMLInMemoryConfigStorage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 核心Service类
 *
 * @author ivhhs
 * @date 2014.10.16
 */
@Service("wechatService")
public class WechatService implements IWechatService {

    @Autowired
    IUserService userService;
    @Autowired
    IMessageService messageService;
    @Autowired
    IAttachmentService attachmentService;

    private static final String DOWNLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    @Value("#{readProperties['wechat.corpId']}")
    private String corpId;
    @Value("#{readProperties['wechat.secret']}")
    private String secret;
    @Value("#{readProperties['upload.file.path']}")
    private String path;

    /**
     * 处理微信发来的请求
     *
     * @param request
     */
    public void processRequest(WxMpXmlMessage request) {
        // xml格式的消息数据
        // 默认返回的文本消息内容
        String access_token = WeixinUtil.getAccessToken(corpId, secret).getToken();
        try {
            // 发送方帐号
            String openId = request.getFromUserName();
            // 消息类型
            String msgType = request.getMsgType();
            Date date = new Date();
            String first = "";
            String keyword1 = "";
            String keyword2 = "";
            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                // 消息类型
                String content = request.getContent();
                if (content.equals("menu")) {
                    buildMenu();
                    return;
                }
                if (StringUtils.isNotEmpty(content) && content.matches("^bd\\(.*")) {
                    String 微信号 = content.substring(3, content.indexOf(")"));
                    User user = userService.selectByWechatNo(微信号);
                    first = "您好，正在绑定微信号铁通工程管理平台。";
                    keyword1 = 微信号;
                    if (user == null) {
                        keyword2 = "微信号没有录入到系统，请联系管理员。";
                    } else {
                        user.setOpenid(openId);
                        userService.update(user);
                        keyword2 = "微信号绑定成功。";
                        if (StringUtils.isEmpty(user.getOrgId())) {
                            keyword2 = keyword2 + "(您没有设置施工队，请联系管理员。)";
                        }
                    }
                } else {
                    User user = userService.selectByOpenId(openId);
                    if (user == null) {
                        first = "您好，需要绑定微信号到铁通工程管理平台。";
                        keyword2 = "未绑定微信号，请回复以下消息到服务号来绑定：bd(您的微信号)。";
                    } else {
                        Message message = new Message();
                        message.setContent(content);
                        message.setFromuser(user.getUserId());
                        message.setId(java.util.UUID.randomUUID().toString());
                        message.setTime(date);
                        message.setTosgdid(user.getOrgId());
                        messageService.insert(message);

                        if (org.apache.commons.lang3.StringUtils.isEmpty(message.getContent())) {
                            return;
                        }
                        final String gcdId = user.getOrgId();
                        final String autoMessage = message.getContent();
                        final String dateTime = DateUtil.FORMATTER_YMDHMS.format(date);
                        sendToBrowers(gcdId, autoMessage, dateTime);
                        return;
                    }
                }

            } // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                String mediaId = request.getMediaId();
                User user = userService.selectByOpenId(openId);
                if (user == null) {
                    first = "您好，正在需要绑定微信号到<铁通工程管理平台>。";
                    keyword2 = "未绑定微信号，请回复以下消息到服务号来绑定：bd(您的微信号)。";
                } else {
                    String attachmentId = java.util.UUID.randomUUID().toString();
                    String uri = FilePathEnum.现场管理.getPath() + user.getOrgId() + "/" + FORMATTER_YMD.format(date);
                    UrlDownloadFile.downLoadFromUrl(DOWNLOAD_URL.replace("ACCESS_TOKEN", access_token).replace("MEDIA_ID", mediaId),
                            FORMATTER_HMS.format(date) + ".jpg",
                            path + uri);
                    Message message = new Message();
                    String src = "data/system/downloadFile.do?attachmentId=" + attachmentId;
                    message.setContent("<a href='javascript:;' onclick='showImage(this)'>"
                            + "<img style='width:400px;height:300px' src='" + src + "'/></a>");
                    message.setFromuser(user.getUserId());
                    message.setId(java.util.UUID.randomUUID().toString());
                    message.setTime(date);
                    message.setTosgdid(user.getOrgId());
                    final String gcdId = user.getOrgId();
                    final String autoMessage = message.getContent();
                    final String dateTime = FORMATTER_YMDHMS.format(date);

                    Attachment attachment = new Attachment();
                    attachment.setId(attachmentId);
                    attachment.setUri(uri);
                    attachment.setFileName(FORMATTER_HMS.format(date) + ".jpg");
                    attachmentService.save(attachment);
                    message.setAttachmentid(attachmentId);
                    messageService.insert(message);
                    sendToBrowers(gcdId, autoMessage, dateTime);
                    return;
                }
            } // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                return;
            } // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                return;
            } // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                return;
            } // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                return;
            } // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = request.getEvent();
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
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
                }
                return;
            }
            String jsonString = MessageUtil.getBangdingMessage(openId, first, keyword1, keyword2);
            WeixinUtil.PostMessage(access_token, "POST", MessageUtil.MB_SEND_URL, jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToBrowers(final String gcdId, final String autoMessage, final String dateTime) {
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session) {
                if (session.getAttribute("gcdId") == null) {
                    return false;
                } else {
                    return (session.getAttribute("gcdId")).equals(gcdId);
                }
            }
        }, new Runnable() {
            private ScriptBuffer script = new ScriptBuffer();

            public void run() {
                script.appendCall("showMessage", autoMessage, dateTime, false);
                Collection<ScriptSession> sessions = Browser
                        .getTargetSessions();
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }

    private void buildMenu() {
        WxMpService wxMpService = new WxMpServiceImpl();
        InputStream inputStream = WxMpServiceInstance.class.getResourceAsStream("/weixin.config.xml");
        WxMpXMLInMemoryConfigStorage config;
        try {
            config = WxMpXMLInMemoryConfigStorage.fromXml(inputStream);
            wxMpService.setWxMpConfigStorage(config);

            WxMenu x5Menu = new WxMenu();
            List<WxMenu.WxMenuButton> x5Meuns = new ArrayList<>();
            WxMenu.WxMenuButton baseManage = new WxMenu.WxMenuButton();
            baseManage.setName("基础管理");
            x5Meuns.add(baseManage);

            List<WxMenu.WxMenuButton> baseMenuSuButtons = new ArrayList<>();
            WxMenu.WxMenuButton orderManage = new WxMenu.WxMenuButton();
            orderManage.setName("订单管理");
            orderManage.setType(WxConsts.BUTTON_VIEW);
            orderManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2forderManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            baseMenuSuButtons.add(orderManage);

            WxMenu.WxMenuButton gzzdManage = new WxMenu.WxMenuButton();
            gzzdManage.setName("规章制度");
            gzzdManage.setType(WxConsts.BUTTON_VIEW);
            gzzdManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fgzzdManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            baseMenuSuButtons.add(gzzdManage);

            WxMenu.WxMenuButton clglManage = new WxMenu.WxMenuButton();
            clglManage.setName("材料管理");
            clglManage.setType(WxConsts.BUTTON_VIEW);
            clglManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fclglManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            baseMenuSuButtons.add(clglManage);

            WxMenu.WxMenuButton sgdwManage = new WxMenu.WxMenuButton();
            sgdwManage.setName("施工队伍");
            sgdwManage.setType(WxConsts.BUTTON_VIEW);
            sgdwManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fsgdwManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            baseMenuSuButtons.add(sgdwManage);
            baseManage.setSubButtons(baseMenuSuButtons);

            WxMenu.WxMenuButton xcglManage = new WxMenu.WxMenuButton();
            xcglManage.setName("现场管理");
            x5Meuns.add(xcglManage);

            List<WxMenu.WxMenuButton> xcglMenuSuButtons = new ArrayList<>();
            WxMenu.WxMenuButton xcglSubManage = new WxMenu.WxMenuButton();
            xcglSubManage.setName("现场管理");
            xcglSubManage.setType(WxConsts.BUTTON_VIEW);
            xcglSubManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fxcglManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            xcglMenuSuButtons.add(xcglSubManage);

            WxMenu.WxMenuButton xcjcManage = new WxMenu.WxMenuButton();
            xcjcManage.setName("现场检查");
            xcjcManage.setType(WxConsts.BUTTON_VIEW);
            xcjcManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config.getAppId() + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fxcjcManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            xcglMenuSuButtons.add(xcjcManage);

            xcglManage.setSubButtons(xcglMenuSuButtons);

            WxMenu.WxMenuButton projectMenuManage = new WxMenu.WxMenuButton();
            projectMenuManage.setName("项目管理");
            x5Meuns.add(projectMenuManage);

            List<WxMenu.WxMenuButton> projectManageButtons = new ArrayList<>();
            WxMenu.WxMenuButton projectManage = new WxMenu.WxMenuButton();
            projectManage.setName("工程承揽情况");
            projectManage.setType(WxConsts.BUTTON_VIEW);
            projectManage.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + config + "&redirect_uri=http%3a%2f%2f139.196.171.130%2fzyqyh%2fmobile%2fprojectManage.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
            projectManageButtons.add(projectManage);
            projectMenuManage.setSubButtons(projectManageButtons);

            x5Menu.setButtons(x5Meuns);
            wxMpService.menuDelete();
            wxMpService.menuCreate(x5Menu);
        } catch (JAXBException ex) {
            Logger.getLogger(WechatService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final String AUTHORIZATION_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    @Override
    public String loginWithCode(String code) {
        String RequestURL = AUTHORIZATION_URL.replace("APPID", corpId).replace("SECRET", secret).replace("CODE", code);
        JSONObject jsonobject = WeixinUtil.httpRequest(RequestURL, "post", "");
        String openId = jsonobject.getString("openid");
        User user = userService.selectByOpenId(openId);
        if (user == null) {
            return "没有绑定微信号，请发送绑定命令到服务号：bd(您的微信号)";
        }
        return "";

    }

}
