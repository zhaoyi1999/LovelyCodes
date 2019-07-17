package com.kgc.pet;

public class Rubbit extends Pet {
	// 耳朵
	private String ear = "长耳";

	public Rubbit() {

	}

	public Rubbit(String name, int health, int love, String ear) {
		super(name, health, love);
		this.ear = ear;
	}

	public String getEar() {
		return ear;
	}

	public void setEar(String ear) {
		if (ear.equals("")) {
			this.ear = "长耳兔";
			System.out.println("品种自动设置为：长耳兔");
			return;
		}
		this.ear = ear;
	}

	/***
	 * 兔子的独有属性——耳朵
	 */
	public void print() {
		super.print();
		System.out.println("我是一只" + this.getEar());
	}

	public void toHospital() {
		if (this.getHealth() < 60) {
			System.out.println("===========================");
			System.out.println("我生病了");
			System.out.println("打针，吃药，阉割");
			this.setHealth(60);
			System.out.println("===========================");
		} else {
			System.out.println("我很健康！");
		}
	}
	
	public void eat(){
		if (this.getHealth()==100) {
			System.out.println("吃饱了，不需要喂食");
		}else {
			System.out.println("吃了一根胡萝卜");
			this.setHealth(this.getHealth()+10);
		}
	}
}
