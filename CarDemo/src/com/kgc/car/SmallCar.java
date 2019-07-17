package com.kgc.car;

//轿车类
public class SmallCar extends Car {

	// 型号
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public SmallCar() {

	}

	public SmallCar(String carId, String carType, int carPrice, String type) {
		super(carId, carType, carPrice);
		this.type = type;
	}

	// 重写父类的计算租金方法，根据自己的计算租金规则
	public float setPrice(int days) {
		float price = this.getCarPrice() * days;
		if (days > 7 && days <= 30) {
			price *= 0.9f;
		} else if (days > 30 && days <= 150) {
			price *= 0.8f;
		} else if (days > 150) {
			price *= 0.7f;
		}

		return price;
	}

}
