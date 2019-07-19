package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

/***
 * 约束客户端的实现类
 * 
 * @author Administrator
 * 
 * @param <T>
 *            发送到服务器端的请求数据类型
 * @param <S>
 *            服务器端推送回来的响应的数据类型
 */
public class DefaultCommunicatorImpl<T extends Serializable, S extends Serializable>
		implements Communicator<T, S> {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public void init(String host, int port) throws UnknownHostException,
			IOException {
		// 创建连接
		socket = new Socket(host, port);
		// 创建输出/输入流
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());

	}

	@SuppressWarnings("unchecked")
	public DataTransfer<S> communicate(DataTransfer<T> input)
			throws IOException, ClassNotFoundException {
		// 通过输出流输出对象
		out.writeObject(input);
		return (DataTransfer<S>) in.readObject();
	}

	public void destroy() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

	// 封装

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

}
