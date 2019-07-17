package com.kgc.pet;

import java.util.Scanner;

public class TestPet {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Penguin p = new Penguin();

		System.out.println("欢迎来到宠物店！");
		Scanner input = new Scanner(System.in);
		String answer;
		boolean result = true;

		do {
			System.out.println("请输入要领养的宠物名：");
			String name = input.next();
			System.out.println("请输入要领养的宠物类型；1.狗    2.企鹅");
			int chance = input.nextInt();
			switch (chance) {
			case 1:
				System.out.println("请输入健康值（1~100之间）：");
				int health=input.nextInt();
				System.out.println("请输入亲密度（1~100之间）：");
				int love=input.nextInt();
				System.out.println("请输入狗的品种：");
				String strain=input.next();
				dog=new Dog(name,health,love,strain);
				dog.print();
				break;
			case 2:
				System.out.println("请选择企鹅的性别：1.Q仔    2.Q妹");
				int sex=input.nextInt();
				Sex sex0;
				if (sex==1) {
					sex0=Sex.Q仔;
				}else if (sex==2) {
					sex0=Sex.Q妹;
				}
				else {
					sex0=Sex.Q仔;
				}
				System.out.println("请输入健康值（1~100之间）：");
				int health2=input.nextInt();
				System.out.println("请输入亲密度（1~100之间）：");
				int love2=input.nextInt();
				p=new Penguin(name,health2,love2,sex0);
				p.print();
				break;

			default:
				System.out.println("对不起，您没有选择宠物类型！");
				break;
			}
			System.out.println("再来一只(y/n)？");
			answer = input.next();
			if (!((answer.equals("y") || answer.equals("Y")) && (!answer
					.equals("n") || !answer.equals("N")))) {
				result = false;
			}
			else {
				System.out.println("输入有误，自动选择：再来一只");
				result=true;
			}
		} while (result);
		System.out.println("谢谢光临！");
	}
}
