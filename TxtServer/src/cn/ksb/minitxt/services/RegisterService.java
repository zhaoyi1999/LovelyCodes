package cn.ksb.minitxt.services;

import java.io.IOException;

import cn.ksb.minitxt.common.entity.DataTransfer;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.BaseServiceImpl;
import cn.ksb.minitxt.utils.UserUtils;

public class RegisterService extends BaseServiceImpl<User> {

	@Override
	public void execute() throws IOException {
		// TODO 注册相关的代码
		// getData()拿到用户相关数据
		// 传递给注册方法 doRegister()返回结果result_int
		int result = UserUtils.doRegister(getData());
		DataTransfer<?> dto = new DataTransfer<>();
		// 将结果封装
		dto.setResult(result);
		// 发送给客户端
		getOut().writeObject(dto);
	}

}
