package HttpSession;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟B/S服务器 类似于一个tomcat
 *
 */
public class EmulateServer {
    public static void main(String[] args) throws IOException {

        //创建一个服务器
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("Server Initialized!");

        while(true){
            //接受请求
            Socket socket = serverSocket.accept();

            //开启多线程
            new Thread(()->{

                FileInputStream fis = null;

                try {
                    //获取请求内容
                    InputStream is = socket.getInputStream();

                    //通过转换流读取到reader
                    InputStreamReader isr = new InputStreamReader(is);

                    //通过reader获取到bufferedReader
                    BufferedReader br = new BufferedReader(isr);

                    //获取第一行内容
                    String str = br.readLine();
                    System.out.println("str = " + str);

                    String[] splitStr = str.split(" ");
                    String webURL = splitStr[1].substring(1);  //HttpSystem/web/index.html

                    System.out.println("webURL = " + webURL);

                    //获取本地的文件输入流
                    fis = new FileInputStream(webURL);

                    //获取socket输出流
                    OutputStream os = socket.getOutputStream();

                    //写入http协议响应头 固定写法
                    os.write("HTTP/1.1 200 OK\r\n".getBytes());
                    os.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
                    //必须要写入空行 否则浏览器不解析
                    os.write("\r\n".getBytes());

                    int len = 0;
                    byte[] bytes = new byte[1024];

                    while((len = fis.read(bytes)) != -1){
                        os.write(bytes,0,len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //释放资源
                    try {
                        if(fis != null){
                            fis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(socket != null){
                            socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }).start();

        }

    }
}
