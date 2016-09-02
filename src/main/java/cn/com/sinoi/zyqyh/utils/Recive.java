/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.utils;

import cn.com.sinoi.zyqyh.system.UdpThreader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Recive {

    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(10000);

            System.out.println("监听开始。。。。。。。。");//打印内容
            while (true) {
                byte[] buf = new byte[1024];//接受内容的大小，注意不要溢出
                DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);//定义一个接收的包
                ds.receive(dp);//将接受内容封装到包中
                String data = new String(dp.getData(), 0, dp.getLength());//利用getData()方法取出内容
                System.out.println(data);//打印内容
                if ("exit".equals(data)) {
                    System.out.println("监听退出。。。。。。。。");//打印内容
                    break;
                }
            }
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
