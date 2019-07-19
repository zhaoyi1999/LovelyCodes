package cn.ksb.minitxt.services;

import java.io.Serializable;

import cn.ksb.minitxt.client.BaseServiceImpl;
import cn.ksb.minitxt.client.Service;
import cn.ksb.minitxt.common.entity.Novel;

public class GetPreviewService extends BaseServiceImpl<Novel> {

	@Override
	public Service<? extends Serializable> execute() {
		System.out.println("预览：" + this.getInputData().getName());
		return null;
	}

}
