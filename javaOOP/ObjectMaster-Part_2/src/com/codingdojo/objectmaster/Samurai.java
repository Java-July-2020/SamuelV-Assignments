package com.codingdojo.objectmaster;

public class Samurai extends Human {

	private static int samuraiCount = 0;
	
	public Samurai() {
		super();
		this.health = 200;
		samuraiCount++;
	}
	
	public void deathBlow (Human human) {
		human.health = 0;
		this.health = this.health/2;
	}
	
	public void meditate () {
		this.health = this.health/2+ this.health;
	}
	
	public static int howMany () {
		return samuraiCount;
	}
	
}
