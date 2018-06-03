package socket;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/28 15:05.
 * @Comment
 */

import sockettest.SocketControl;

import java.net.*;
import java.io.*;
/**
 *客户端
 *负责接收数据
 *
 */
public class SocketClientTest {
    private static final String HOST = "localhost";//192.168.0.200
    private static final int PORT = 8082;
    static Socket socket =null;
    private static BufferedReader dis = null;
    private static InputStream is = null;
    private static InputStreamReader inputStreamReader=null;
    private static void test() {

        try {
            socket=new Socket(HOST,PORT);
            System.out.println("PPP");
            is = socket.getInputStream();
            byte buf[] = new byte[1024];
            int len = 0;
            int i = 0;
            while (len!=1) {
                len = is.read(buf);
                String str = new String(buf, 0, len);
                System.out.println("收到的字符为:"+str.trim()+"字符长度"+str.length());
                if(str!=null)
                {
                    SocketControl.select(str.trim());
                    //break;
                }


                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
           // e.printStackTrace();
             System.out.println("继续监听");
             test();
        }
    }


    public static void main(String[] args) {

        test();
    }
}