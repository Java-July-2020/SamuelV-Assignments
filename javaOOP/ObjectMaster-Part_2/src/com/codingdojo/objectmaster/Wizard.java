package com.codingdojo.objectmaster;

public class Wizard extends Human{

	public Wizard() {
		super();
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal (Human human) {
		human.health += this.intelligence;
	}
	
	public void fireball (Human human) {
		human.health -= 3*this.intelligence;
	}
}
