package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoClient {
    public static void main(String[] args) throws IOException {

        //创建一个套接字对象
        Socket socket = new Socket("127.0.0.1",6666);
        //获取一个网络字节输出流
        OutputStream os = socket.getOutputStream();
        //写入数据
        os.write("Hey Boy!".getBytes());
        //获取输入流
        InputStream is = socket.getInputStream();
        //获取数据
        byte[] bytes = new byte[1024];
        int read = is.read(bytes);

        System.out.println(new String(bytes,0,read));

        //关闭资源
        socket.close();

    }
}
