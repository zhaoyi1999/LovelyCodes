package cn.ksb.minitxt.services;

import java.io.IOException;

import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.UserUtils;

public class LoginService extends BaseServiceImpl<User> {

	public void execute() throws IOException {
		// TODO 登录相关的代码
		// getData()拿到用户相关数据
		// 传递给登录方法 doLogin()返回结果result_int
		int result = UserUtils.doLogin(getData());
		// 登录成功
		// 1.查询小说分类：作为返回结果发送给客户端
		// 2.返回之后，客户端重新发送请求，获取小说分类
		DataTransfer<?> dto = new DataTransfer<>();
		// 将结果封装
		dto.setResult(result);
		// 发送给客户端
		getOut().writeObject(dto);

	}

}
