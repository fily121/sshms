package cn.com.sinoi.zyqyh.system;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

/**
 * 服务启动时，启动UDP数据接收线程。
 *
 * @author 强成西
 */
public class UdpListener extends HttpServlet implements ServletContextListener {

    private static final long serialVersionUID = 3531530773005793191L;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        UdpThreader udpThreader = new UdpThreader();
//        udpThreader.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
