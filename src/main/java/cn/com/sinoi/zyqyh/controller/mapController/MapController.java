package cn.com.sinoi.zyqyh.controller.mapController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: 测试udp接收数据
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
public class MapController {

    @RequestMapping(value = "data/testLocation.do", method = RequestMethod.GET)
    public void testLocation(String ip, Integer port, String data, HttpServletResponse response) throws IOException {
        DatagramSocket ds = null;  //建立套间字udpsocket服务
        if (data == null) {
            data = "1,1,1,201609012121";
        }
        try {
            ds = new DatagramSocket(8999);  //实例化套间字，指定自己的port
        } catch (SocketException e) {
            System.out.println("Cannot open port!");
            System.exit(1);
        }

        byte[] buf = data.getBytes();  //数据
        InetAddress destination = null;
        try {
            destination = InetAddress.getByName(ip);  //需要发送的地址
        } catch (UnknownHostException e) {
            System.out.println("Cannot open findhost!");
            System.exit(1);
        }
        DatagramPacket dp
                = new DatagramPacket(buf, buf.length, destination, port);
        //打包到DatagramPacket类型中（DatagramSocket的send()方法接受此类，注意10000是接受地址的端口，不同于自己的端口！）

        try {
            ds.send(dp);  //发送数据
        } catch (IOException e) {
        }
        ds.close();
        PrintWriter out = response.getWriter();
        out.print("ok");
        out.close();
        out = null;
    }
}
