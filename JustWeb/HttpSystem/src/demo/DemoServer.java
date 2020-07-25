package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
    public static void main(String[] args) throws IOException {

        //创建一个服务器对象
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("Server Initialized!");

        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int length = is.read(bytes);

        System.out.println(new String(bytes,0,length));

        //返回数据
        OutputStream os = socket.getOutputStream();
        os.write("Hey Bitch!".getBytes());

        socket.close();
        serverSocket.close();

    }
}
