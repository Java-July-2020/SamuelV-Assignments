package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human human_1 = new Human();
		Human human_2 = new Human();
		
		System.out.println("The initial health levels of human_1 and human_2 are " +  	human_1.health + ", and " + human_2.health + ", respectivetly");
		
		human_1.attack(human_2);
		
		System.out.println("The final health levels of human_1 and human_2 are " +  	human_1.health + ", and " + human_2.health + ", respectivetly");

	}

}
