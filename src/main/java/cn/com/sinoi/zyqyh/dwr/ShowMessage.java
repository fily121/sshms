package cn.com.sinoi.zyqyh.dwr;

import cn.com.sinoi.zyqyh.service.IMessageService;
import cn.com.sinoi.zyqyh.vo.Message;
import java.util.Collection;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowMessage {

    @Autowired
    IMessageService messageService;

    public void sendMessageAuto(String gcdid, String message, String datetime) {

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

                Message message = new Message();
                message.setContent(autoMessage);
                message.setTosgdid(gcdId);
                message.setFromuser(dateTime);
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
