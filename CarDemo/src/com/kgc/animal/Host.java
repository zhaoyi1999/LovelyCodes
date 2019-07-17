package com.kgc.animal;

//主人类
public class Host {
	// 赠送动物
	public Animal sendAnimal(String type) {
		Animal animal=null;
		if (type.equals("cat")) {
			animal=new Cat();
		} else if (type.equals("dog")) {
			animal=new Dog();
		}else if (type.equals("duck")) {
			animal=new Duck();
		}
		return animal;
	}
}
