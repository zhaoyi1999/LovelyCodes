package com.kgc.pet;

public class TestPet2 {
	public static void main(String[] args) {
		// Master master=new Master();

		// Dog dog = new Dog("旺财", 30, 90, "泰迪");
		// dog.print();
		// master.cure(dog);
		// dog.print();
		// master.cure(dog);

		// Pet rubbit=new Rubbit("旺财", 30, 90, "长耳兔");
		// rubbit.print();
		// master.cure(rubbit);
		// master.feed(rubbit);
		// rubbit.print();
		Pet dog = new Dog();
		if (dog instanceof Dog) {
			Dog d = (Dog) dog;
			d.catchFly();
		} else if (dog instanceof Penguin) {
			Penguin p = (Penguin) dog;
			p.swim();
		}

	}

}
