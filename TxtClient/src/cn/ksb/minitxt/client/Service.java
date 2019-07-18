package cn.ksb.minitxt.client;

import java.io.Serializable;

/***
 * 客户端功能接口
 * 
 * @author Administrator
 * @param <T>
 * 
 */
public interface Service<T extends Serializable> {

	/***
	 * 传递参数方法
	 * 
	 * @param input
	 */
	public void setInputData(T inputData);

	/***
	 * 功能执行方法
	 * 
	 * @return 返回下一个功能接口的实现类
	 */
	public Service<? extends Serializable> execute();

}
