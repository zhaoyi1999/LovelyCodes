package com.kgc.carMgr;

import com.kgc.car.*;

//汽车业务类
public class carManager {
	// 汽车类型数组，将该数组声明为父类类型
	public Car[] cars = new Car[8];

	// 初始化汽车信息
	public void chuShiHua() {
		cars[0] = new SmallCar("苏A00000", "玛莎拉蒂", 800, "XonS");
		cars[1] = new SmallCar("苏A00001", "玛莎拉蒂", 600, "Xon");
		cars[2] = new SmallCar("苏A00002", "保时捷", 300, "卡宴");
		cars[3] = new SmallCar("苏A00003", "保时捷", 600, "卡宴S");
		cars[4] = new Bus("苏A00004", "奔驰", 8000, 16);
		cars[5] = new Bus("苏A00005", "奔驰", 15000, 32);
		cars[6] = new Bus("苏A00006", "金龙", 800, 16);
		cars[7] = new Bus("苏A00007", "金龙", 1500, 32);

	}

	// 租车
	//如果租赁的是客车，需要条件	品牌 座位 型号null
	//如果租赁的是轿车，需要条件	品牌 型号 座位0
	public Car carOut(String carType, String type, int seat) {
		Car car = null;
		for (Car items : cars) {
			if (items instanceof SmallCar) {
				SmallCar sc = (SmallCar) items;
				if (sc.getCarType().equals(carType)
						&& sc.getType().equals(type)) {
					car = sc;
					break;
				}
			} else {
				Bus bus = (Bus) items;
				if (bus.getCarType().equals(carType) && bus.getType() == seat) {
					car = bus;
					break;
				}
			}
		}
		return car;
	}
}
