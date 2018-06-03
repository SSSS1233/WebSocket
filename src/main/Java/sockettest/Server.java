package sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/24 23:53.
 * @Comment
 */

public class Server {
    private int port = 9090;
    private ServerSocket serverSocket;

    public Server() throws Exception {
        serverSocket = new ServerSocket(port, 3);
        System.out.println("服务器启动!");
    }

    public void service() {
        InputStream stream = null;

        Socket socket = null;
        try {
            socket = serverSocket.accept();
            stream = socket.getInputStream();
            byte buf[] = new byte[1024];
            int len = 0;
            int i = 0;
            while (len!=-1) {
                len = stream.read(buf);

                String str = new String(buf, 0, len);
                System.out.println("收到的字符为:"+str+"字符长度"+str.length());
                if(str!=null)
                {
                    SocketControl.select(str.trim());
                }


                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        //Thread.sleep(60000*10);
        server.service();
    }
}