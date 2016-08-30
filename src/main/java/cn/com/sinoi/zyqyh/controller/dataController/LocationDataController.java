package cn.com.sinoi.zyqyh.controller.dataController;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Title: 基础管理管理控制器
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author 强成西
 *
 * <pre>
 *         修改记录: 版本号 修改人 修改日期 修改内容
 */
@Controller
@RequestMapping("data/location")
public class LocationDataController {

    private static final Logger logger = Logger.getLogger(LocationDataController.class);

    @RequestMapping("showLocation.do")
    @ResponseBody
    public void showLocation(String longitude, String dimensionality, String cph, String datetime) {

        final String 经度 = longitude;
        final String 维度 = dimensionality;
        final String 车牌号 = cph;
        final String dateTime = datetime;
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session) {
                if (session.getAttribute("location") == null) {
                    return false;
                } else {
                    return (session.getAttribute("location")).equals("location");
                }
            }
        }, new Runnable() {
            private ScriptBuffer script = new ScriptBuffer();

            public void run() {
                script.appendCall("showLocation", 经度, 维度, 车牌号, dateTime);
                Collection<ScriptSession> sessions = Browser
                        .getTargetSessions();
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }

}
