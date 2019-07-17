package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/***
 * 服务器功能接口 具有多线程能力
 */
public interface Service<T extends Serializable> extends Runnable {

	/***
	 * 初始化方法
	 * 
	 * @param socket
	 * @param in
	 * @param out
	 */
	public void init(Socket socket, ObjectInputStream in,
			ObjectOutputStream out, T data);

	/***
	 * 释放资源方法
	 * 
	 * @throws IOException
	 */
	public void destroy() throws IOException;

}
