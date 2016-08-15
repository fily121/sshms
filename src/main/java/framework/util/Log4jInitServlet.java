package framework.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

//通过在web.xml文件配置启动这个类，用来初始化log4j

@SuppressWarnings("serial")
public class Log4jInitServlet extends HttpServlet {
    
    /**
     * Servlet初始化
     */
    public void init(ServletConfig config) throws ServletException {
       
        String root = config.getServletContext().getRealPath("/");
       
        String log4jLocation = config.getInitParameter("log4jLocation");
       
        System.setProperty("webRoot", root);
       
        System.out.println("logfjLocation:" + log4jLocation);
       
        if (!"".equals(log4jLocation)) {
            PropertyConfigurator.configure(root + log4jLocation);
        }
       
    }
       
}