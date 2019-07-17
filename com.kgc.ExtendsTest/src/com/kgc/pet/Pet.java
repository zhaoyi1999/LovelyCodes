package com.kgc.pet;

/***
 * 父类：宠物类
 */
public abstract class Pet {
	// 姓名
	private String name="无名氏";
	// 健康度
	private int health=30;
	// 亲密度
	private int love=70;

	public Pet() {

	}

	public Pet(String name, int health, int love) {
		this.name = name;
		this.health = health;
		this.love = love;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health <= 0 && health > 100) {
			// 如果赋值不正确，强制赋值，结束方法
			this.health = 60;
			System.out.println("健康值不能为小于0或大于100！");
			return;
		}
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		if (love <= 0 && love > 100) {
			System.out.println("亲密度不能为小于0或大于100！");
			this.love = 60;
			return;
		}
		this.love = love;
	}

	/***
	 * 输出宠物信息
	 */
	public void print() {
		System.out.println("我的名字叫：" + this.getName() + "\n健康值是："
				+ this.getHealth() + "\n亲密度：" + this.getLove());

	}

	
	/**
	 * 有抽象方法的类一定是抽象类
	 * 抽象方类不一定有抽象方法
	 * 抽象类不能实例化，如：Pet pet ≠ new Pet();
	 * 抽象类的子类可以是普通类，该普通类要实现抽象类中的抽象方法 
	 * 抽象类的子类也可以是抽象类
	 * */
	public abstract void toHospital();
	public abstract void eat();
}
