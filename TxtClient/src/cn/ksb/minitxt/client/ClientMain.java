package cn.ksb.minitxt.client;

import java.io.Serializable;

import cn.ksb.minitxt.common.constants.Constants;

/***
 * 客户端入口类
 * 
 * @author Administrator
 * 
 */
public class ClientMain {
	public static void main(String[] args) {
		new ClientMain().startClient();
	}

	public void startClient() {
		Service<? extends Serializable> service = ServiceFactory
				.getService(Constants.COMMAN_START);
		while (true) {
			if (service == null)
				System.out.println("退出应用。");
			service = service.execute();
		}
	}
}
