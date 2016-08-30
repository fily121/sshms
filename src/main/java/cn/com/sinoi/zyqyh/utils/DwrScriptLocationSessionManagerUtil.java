package cn.com.sinoi.zyqyh.utils;

import javax.servlet.ServletException;
import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;

public class DwrScriptLocationSessionManagerUtil extends DwrServlet {

    private static final long serialVersionUID = 3309335456400246712L;

    @Override
    public void init() throws ServletException {
        Container container = ServerContextFactory.get().getContainer();
        ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
        ScriptSessionListener listener = new ScriptSessionListener() {
            @Override
            public void sessionCreated(ScriptSessionEvent ev) {
                ev.getSession().setAttribute("location", "location");
            }

            @Override
            public void sessionDestroyed(ScriptSessionEvent ev) {
                System.out.println("a ScriptSession is distroyed");
            }
        };
        manager.addScriptSessionListener(listener);
    }
}
