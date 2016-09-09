package cn.com.sinoi.zyqyh.service;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;

public interface IWechatService {

    void processRequest(WxMpXmlMessage Msg);

    String loginWithCode(String code);
}
