package com.kgc.car;

//客车类
public class Bus extends Car {

	// 座位数
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Bus() {

	}

	public Bus(String carId, String carType, int carPrice, int type) {
		super(carId, carType, carPrice);
		this.type = type;
	}

	// 重写父类的计算租金方法，根据自己的计算租金规则
	public float setPrice(int days) {
		float price = this.getCarPrice() * days;
		if (days >= 3 && days < 7) {
			price *= 0.9f;
		} else if (days >= 7 && days < 30) {
			price *= 0.8f;
		} else if (days >= 30 && days < 150) {
			price *= 0.7f;
		} else if (days >= 150) {
			price *= 0.6f;
		}

		return price;
	}

}
