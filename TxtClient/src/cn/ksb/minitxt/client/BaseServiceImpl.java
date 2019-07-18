package cn.ksb.minitxt.client;

import java.io.Serializable;

public abstract class BaseServiceImpl<T extends Serializable> implements
		Service<T> {
	private T inputData;

	@Override
	public void setInputData(T inputData) {
		this.inputData = inputData;
	}

	public T getInputData() {
		return inputData;
	}

}
