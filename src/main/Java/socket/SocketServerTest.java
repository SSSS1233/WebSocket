package socket;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/28 15:07.
 * @Comment
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * 服务端
 * 负责发送数据
 */
public class SocketServerTest {

    private static final int PORT = 8082;


    public static void test() {
        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream out = null;
        Scanner scanner=new Scanner(System.in);
        try {
            server = new ServerSocket(PORT);
            socket = server.accept();
            out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                Thread.sleep(1000);
                System.out.println("请输入:");
                String str=scanner.next();
                out.writeUTF(str);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        test();
    }
}
