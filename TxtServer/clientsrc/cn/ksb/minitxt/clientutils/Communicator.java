package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

/***
 * 约束客户端的接口
 * 
 * @param <S>
 * @param <T>
 */
public interface Communicator<T extends Serializable, S extends Serializable> {

	/***
	 * 初始化方法：创建连接
	 * 
	 * @param host
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void init(String host, int port) throws UnknownHostException,
			IOException;

	/***
	 * 相互通信方法
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public DataTransfer<S> communicate(DataTransfer<T> input)
			throws IOException, ClassNotFoundException;

	/***
	 * 释放资源方法
	 * 
	 * @throws IOException
	 */
	public void destroy() throws IOException;

}
