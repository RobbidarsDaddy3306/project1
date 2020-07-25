package demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传的服务端
 * 1. 获取客户端发送的文件数据
 * 2. 将文件写出到本地硬盘
 */
public class DemoUploadServer {
    public static void main(String[] args) throws IOException {

        //创建一个服务器
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("Server Initialized!");

        while (true){

            Socket socket = serverSocket.accept();

            new Thread(()->{

                int num = new Random().nextInt(9999);
                long time = System.currentTimeMillis();
                String name = time + "" + num;

                FileOutputStream fos = null;

                try {
                    InputStream is = socket.getInputStream();

                    File file = new File("D:/upload");
                    if(!file.exists()){
                        file.mkdir();
                    }

                    fos = new FileOutputStream(file+"/"+name+".png");

                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while ((len = is.read(bytes)) != -1){
                        fos.write(bytes,0,len);
                    }

                    //给客户端返回数据
                    OutputStream os = socket.getOutputStream();
                    os.write("上传成功!".getBytes());


                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(fos != null){
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        if(socket!=null){
                            socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        //serverSocket.close();
    }

}
