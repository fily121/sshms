package cn.com.sinoi.zyqyh.dwr;

import cn.com.sinoi.zyqyh.utils.DwrScriptLocationSessionManagerUtil;
import javax.servlet.ServletException;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

public class ShowLocation {

    public void onLoad() {
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        scriptSession.setAttribute("location", "location");
        DwrScriptLocationSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptLocationSessionManagerUtil();
        try {
            dwrScriptSessionManagerUtil.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
