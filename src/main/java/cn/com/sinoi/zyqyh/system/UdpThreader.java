/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.system;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

/**
 * 监听UDP10000端口数据的线程，接收到数据时，请求本地定位地址
 *
 * @author admin
 */
public class UdpThreader extends Thread {

    private static final String URL = "http://localhost:8081/zyqyh/data/location/showLocation.do";

    @Override
    public void run() {
        DatagramSocket ds = null;
        while (true) {
            try {
                ds = new DatagramSocket(10000);

                System.out.println("监听开始。。。。。。。。");//打印内容
                byte[] buf = new byte[1024];//接受内容的大小，注意不要溢出
                DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);//定义一个接收的包
                ds.receive(dp);//将接受内容封装到包中
                String data = new String(dp.getData(), 0, dp.getLength());//利用getData()方法取出内容
                System.out.println(data);//打印内容
                if ("exit".equals(data)) {
                    System.out.println("监听退出。。。。。。。。");//打印内容
                    break;
                }
                if (StringUtils.isEmpty(data)) {
                    continue;
                }
                String[] datas = data.split(",");
                if (datas.length != 4) {
                    continue;
                }
                final String 经度 = datas[1];
                final String 维度 = datas[2];
                final String 车牌号 = datas[0];
                final String dateTime = datas[3];
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
            } catch (SocketException ex) {
                Logger.getLogger(UdpThreader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UdpThreader.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (ds != null) {
                    ds.close();//关闭资源
                }
            }
        }
    }
}
