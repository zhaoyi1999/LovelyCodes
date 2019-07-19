package cn.ksb.minitxt.services;

import java.io.Serializable;

import cn.ksb.minitxt.client.BaseServiceImpl;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.common.entity.Classification;

public class UploadService extends BaseServiceImpl<Classification> {

	@Override
	public Service<? extends Serializable> execute() {
		System.out.println("向" + this.getInputData().getClassname() + "上传文件");
		return null;
	}

}
