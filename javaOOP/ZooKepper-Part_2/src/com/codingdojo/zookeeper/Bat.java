package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	public void fly() {
		super.setEnergyLevel(super.getEnergyLevel()-10);
		System.out.println("Wuiii, I am flying!!!");
	}
	public void eatHumans() {
		super.setEnergyLevel(super.getEnergyLevel()+25);
		System.out.println("Grunch, Grunch, Grunch!!!, this human is delicious!!!");
	}
	public void attackTown() {
		super.setEnergyLevel(super.getEnergyLevel()-100);
		System.out.println("Wahahaha, this town will perish!!");
	}
}
