package com.kgc.goods;

public class Test {
	public static void main(String[] args) {
		Goods goods = Factory.getGoods("TV");
		goods.print();
		Goods.staticTest();

		// 绑定机制：静态绑定 动态绑定
		// 实例方法（动态绑定机制） 与引用变量实际引用的对象绑定，调用重写后的方法，由运行时的jvm决定
		// 静态方法（静态绑定机制） 与引用变量所声明的类型绑定，实际上在编译阶段就做了绑定
		// 成员变量（包括静态变量和实例变量） 与引用变量所声明的类型绑定，实际上在编译阶段就做了绑定

		// Father f = new Son();
		// System.out.println(f.v1);
		// System.out.println(f.staticV2);
		// f.m1();
		// Father.staticM2();

	}
}
