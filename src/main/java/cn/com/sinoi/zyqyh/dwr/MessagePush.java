/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.dwr;

import cn.com.sinoi.zyqyh.utils.DwrScriptSessionManagerUtil;
import javax.servlet.ServletException;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

/**
 *
 * @author admin
 */
public class MessagePush {

    public void onPageLoad(String gcdId) {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute("gcdId", gcdId);
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
        try {
            dwrScriptSessionManagerUtil.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
