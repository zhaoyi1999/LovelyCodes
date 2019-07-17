package com.kgc.pet;

/***
 * 狗类——继承：宠物类
 */
public class Dog extends Pet {
	// 品种
	private String strain = "聪明的拉布拉多犬";

	public Dog(){
		
	}
	
	public Dog(String name,int health,int love,String strain){
		super(name,health,love);
		this.strain=strain;
	}
	
	
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		if (strain.equals("")) {
			this.strain = "聪明的拉布拉多犬";
			System.out.println("品种自动设置为：聪明的拉布拉多犬");
			return;
		}
		this.strain = strain;
	}

	/***
	 * 狗的独有属性——品种
	 */
	public void print(){
		super.print();
		System.out.println("我是一只"+this.getStrain());
	}
	
	public void toHospital(){
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
	
	/***
	 * 喂食方法
	 */
	public void eat(){
		if (this.getHealth()==100) {
			System.out.println("吃饱了，不需要喂食");
		}else {
			System.out.println("吃了一根骨头");
			this.setHealth(this.getHealth()+3);
		}
	}
	
	/***
	 * 子类独有方法
	 */
	public void catchFly(){
		System.out.println("狗在叼飞盘");
	}
}
