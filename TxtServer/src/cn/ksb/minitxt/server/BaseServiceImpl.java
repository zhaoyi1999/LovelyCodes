package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/***
 * 实现基本方法的抽象类
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public abstract class BaseServiceImpl<T extends Serializable> implements
		Service<T> {

	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private T data;

	@Override
	public void init(Socket socket, ObjectInputStream in,
			ObjectOutputStream out, T data) {
		this.socket = socket;
		this.in = in;
		this.out = out;
		this.data = data;
	}

	/***
	 * 个性代码 在父类中使用protected限制非子类对象的调用
	 * 
	 * @throws IOException
	 */
	abstract protected void execute() throws IOException;

	/***
	 * 对run()进行约束，强制释放资源 方案：引入新的抽象方法execute() 在execute()方法里编写个性代码
	 */
	public void run() {
		try {
			execute();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				destroy();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() throws IOException {
		in.close();
		out.close();
		socket.close();
	}

	
	//封装
	
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
