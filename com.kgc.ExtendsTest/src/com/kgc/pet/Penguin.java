package com.kgc.pet;

/***
 * 企鹅类——继承：宠物类
 */
public class Penguin extends Pet {
	// 性别
	private Sex sex = Sex.Q仔;

	public Penguin(){
		
	}
	
	public Penguin(String name,int health,int love,Sex sex){
		super(name,health,love);
		this.sex=sex;
	}
	
	public void toHospital(){
		if (this.getHealth() < 60) {
			System.out.println("===========================");
			System.out.println("我生病了");
			System.out.println("疗养，吃药，阉割");
			this.setHealth(60);
			System.out.println("===========================");
		} else {
			System.out.println("我很健康！");
		}
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex=sex;
	}

	/***
	 * 企鹅的独有属性——性别
	 */
	public void print() {
		super.print();
		System.out.println("我的性别是：" + this.getSex());
	}
	public void eat(){
		if (this.getHealth()==100) {
			System.out.println("吃饱了，不需要喂食");
		}else {
			System.out.println("吃了一条鱼");
			this.setHealth(this.getHealth()+5);
		}
	}
	
	
	/***
	 * 子类独有方法
	 */
	public void swim(){
		System.out.println("企鹅游泳");
	}
}
