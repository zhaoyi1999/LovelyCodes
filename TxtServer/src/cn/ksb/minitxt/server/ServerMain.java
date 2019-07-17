package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import cn.ksb.minitxt.common.entity.DataTransfer;

/***
 * 服务器进程
 * 
 * @author Administrator
 * 
 */
public class ServerMain {

	/**
	 * 服务器入口方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerMain().startServer();
	}

	/***
	 * 启动服务器
	 */
	public <E extends Serializable> void startServer() {
		try {
			// 监听指定的端口号
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Init
					.getProperty("socket.server.port")));
			System.out.println("服务器启动成功");

			//主线程可以不断的接受请求
			while (true) {
				// 等待客户端连接指定端口号serverSocket.accept()
				Socket socket = serverSocket.accept();
				// socket.getInetAddress() 获取发送请求的IP地址
				System.out.println("客户端：" + socket.getInetAddress() + "获取了连接");
				// 创建服务器和客户端之间的输入输出流
				ObjectInputStream in = new ObjectInputStream(
						socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(
						socket.getOutputStream());

				// 获取客户端的目的，返回关键字-key
				@SuppressWarnings("unchecked")
				DataTransfer<E> dataTransfer = (DataTransfer<E>) in
						.readObject();
				// 获得关键字
				System.out.println("请求：" + dataTransfer.getKey());

				// 通过关键字-key 读取配置文件 获取类名并实例化
				Service<E> service = ServiceFactory.getService(dataTransfer
						.getKey());
				// 初始化
				service.init(socket, in, out, dataTransfer.getData());
				// 作为线程去处理
				new Thread(service).start();

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
