package com.codingdojo.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		Bat Dracula = new Bat(300);
		
		System.out.println("The initial energy level of Dracula is: "+ Dracula.getEnergyLevel());
		
		Dracula.attackTown();
		Dracula.attackTown();
		Dracula.attackTown();
		Dracula.eatHumans();
		Dracula.eatHumans();
		Dracula.fly();
		Dracula.fly();
		
		System.out.println("The finaleEnergy level of DK is: "+ Dracula.getEnergyLevel());

	}

}
