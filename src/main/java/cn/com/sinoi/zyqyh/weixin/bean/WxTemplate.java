/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.weixin.bean;

import cn.com.sinoi.zyqyh.controller.UserController;
import cn.com.sinoi.zyqyh.weixin.AccessToken;
import cn.com.sinoi.zyqyh.weixin.WeixinUtil;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class WxTemplate {

    /**
     * 模板消息id
     */
    private String template_id;
    /**
     * 用户openId
     */
    private String touser;
    /**
     * URL置空，则在发送后，点击模板消息会进入一个空白页面（ios），或无法点击（android）
     */
    private String url;
    /**
     * 标题颜色
     */
    private String topcolor;
    /**
     * 详细内容
     */
    private Map<String, TemplateData> data;

    private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * 发送模板消息 appId 公众账号的唯一标识 appSecret 公众账号的密钥 openId 用户标识
     */
    public void send_template_message(String appId, String appSecret, String openId) {
        AccessToken token = WeixinUtil.getAccessToken(appId, appSecret);
        String access_token = token.getToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
        WxTemplate temp = new WxTemplate();
        temp.setUrl("http://weixin.qq.com/download");
        temp.setTouser(openId);
        temp.setTopcolor("#000000");
//        temp.setTemplate_id("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
        temp.setTemplate_id("LBBm6qscHUcz-0Gh7PlBonsLKtJBHjCLIirnaiBZ4xQ");
        Map<String, TemplateData> m = new HashMap<String, TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("这里填写您要发送的模板信息");
        m.put("first", first);
        TemplateData name = new TemplateData();
        name.setColor("#000000");
        name.setValue("另一行内人");
        m.put("name", name);
        TemplateData wuliu = new TemplateData();
        wuliu.setColor("#000000");
        wuliu.setValue("N行");
        m.put("wuliu", wuliu);
        TemplateData orderNo = new TemplateData();
        orderNo.setColor("#000000");
        orderNo.setValue("**666666");
        m.put("orderNo", orderNo);
        TemplateData receiveAddr = new TemplateData();
        receiveAddr.setColor("#000000");
        receiveAddr.setValue("*测试模板");
        m.put("receiveAddr", receiveAddr);
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        remark.setValue("***备注说明***");
        m.put("Remark", remark);
        temp.setData(m);
        String jsonString = JSONObject.fromObject(temp).toString();
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
        System.out.println(jsonObject);
        int result = 0;
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                logger.debug("错误 errcode:{" + jsonObject.getInt("errcode") + "} errmsg:{" + jsonObject.getString("errmsg") + "}");
            }
        }
        logger.info("模板消息发送结果：" + result);
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TemplateData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }

}
