package cn.com.sinoi.zyqyh.dwr;

import java.util.Collection;
import org.apache.commons.lang3.StringUtils;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

public class ShowMessage {

    public void sendMessageAuto(String gcdid, String message, String datetime) {
        if (StringUtils.isEmpty(message)) {
            return;
        }

        final String gcdId = gcdid;
        final String autoMessage = message;
        final String dateTime = datetime;
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
                script.appendCall("showMessage", autoMessage, dateTime);
                Collection<ScriptSession> sessions = Browser
                        .getTargetSessions();
                for (ScriptSession scriptSession : sessions) {
                    scriptSession.addScript(script);
                }
            }
        });
    }
}
