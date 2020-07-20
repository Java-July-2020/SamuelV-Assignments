package com.codingdojo.zookeeper;

public class Mammal {

	protected int energyLevel;
	
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	public int displayEnergy(){
		System.out.println("The energy level of this animal is: " + this.energyLevel);
		return this.energyLevel;
		
	}
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}

