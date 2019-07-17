package com.kgc.pet;

/***
 * 主人类
 */
public class Master {

	/***
	 *看病方法 
	 */
	public void cure(Pet pet) {
		if (pet.getHealth() < 60) {
			pet.toHospital();
		}
	}
	
	/***
	 * 喂食方法
	 */
	public void feed(Pet pet){
		pet.eat();
	}
	
}
