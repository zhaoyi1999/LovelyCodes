package com.kgc.car;

//汽车类
public abstract class Car {
	// 车牌号 品牌 日租金
	private String carId;
	private String carType;
	private int carPrice;

	public Car() {
		
	}

	public Car(String carId, String carType, int carPrice) {
		this.carId = carId;
		this.carType = carType;
		this.carPrice = carPrice;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	// 计算租金（抽象方法）
	public abstract float setPrice(int days);

}
