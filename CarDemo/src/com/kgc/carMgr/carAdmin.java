package com.kgc.carMgr;

import java.util.Scanner;

import com.kgc.car.*;

/***
 * 汽车租赁管理类：测试类
 */
public class carAdmin {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		carManager carMgr = new carManager();
		// 租赁公司首先要买汽车
		carMgr.chuShiHua();
		System.out.println("==========欢迎光临租赁公司==========");
		System.out.println("1.轿车\t2.客车");
		System.out.print("请选择要租赁的汽车类型：");
		int carTypeId = input.nextInt();
		String carType = "";	//品牌
		String type = "";		//型号
		int seat = 0;			//座位

		if (carTypeId == 1) {
			// 租赁轿车
			System.out.print("请选择您要租赁的轿车品牌（1.玛莎拉蒂2.保时捷）：");
			int choose=input.nextInt();
			if (choose==1) {
				carType="玛莎拉蒂";
				System.out.print("请选择您要租赁的型号（1.XonS2.Xon）：");
				type=(input.nextInt()==1)?"XonS":"Xon";
			}else if (choose==2) {
				carType="保时捷";
				System.out.print("请选择您要租赁的型号（1.卡宴2.卡宴S）：");
				type=(input.nextInt()==1)?"卡宴":"卡宴S";
			}
			
		} else if (carTypeId == 2) {
			// 租赁轿车

		}
		
		Car car=carMgr.carOut(carType, type, seat);
		System.out.print("请选择租赁天数：");
		int days=input.nextInt();
		float money=car.setPrice(days);
		System.out.println("租车成功，请按照车牌号提车："+car.getCarId());
		System.out.println("需要支付："+money+"元");
		
	}

}
