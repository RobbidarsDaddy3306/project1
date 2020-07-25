package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传的客户端
 * 1. 建立连接
 * 2. 读取本地硬盘的文件
 * 3. 写入到服务器端
 */
public class DemoUploadClient {
    public static void main(String[] args) throws IOException {

        //建立连接
        Socket socket = new Socket("127.0.0.1", 6666);

        //创建本地输入流
        FileInputStream fis = new FileInputStream("C:/Users/DELL/Desktop/desktop.png");

        //获取网络输出流
        OutputStream os = socket.getOutputStream();

        //将文件写入服务器
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }

        socket.shutdownOutput();

        //读取服务器返回的数据
        InputStream is = socket.getInputStream();

        System.out.println(new String(bytes,0,is.read(bytes)));

        //释放资源
        fis.close();
        socket.close();


    }

}
