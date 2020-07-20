package com.codingdojo.objectmaster;

public class HumanTest {
	public static void main(String[] args) {
		Human human_1 = new Human();
		Human human_2 = new Human();
		Ninja ninja_1 = new Ninja();
		Ninja ninja_2 = new Ninja();
		Wizard wizard_1 = new Wizard();
		Wizard wizard_2 = new Wizard();
		Samurai samurai_1 = new Samurai();
		Samurai samurai_2 = new Samurai();
		
		
		System.out.println("\nI) HUMAN (ATTACK)\n");
		
		System.out.println("The initial health levels of human_1 and human_2 are " +  	human_1.health + ", and " + human_2.health + ", respectivetly");
		
		System.out.println("human_1 attacks human_2"); 
		human_1.attack(human_2);
		
		System.out.println("The final health levels of human_1 and human_2 are " +  	human_1.health + ", and " + human_2.health + ", respectivetly");
		
		
		System.out.println("\nII) WIZARD (HEAL)\n");
System.out.println("The initial health levels of wizard_1 and ninja_2 are " +  	wizard_1.health + ", and " + ninja_2.health + ", respectivetly");
		
		System.out.println("wizard_1 heal ninja_2"); 
		wizard_1.heal(ninja_2);
		
		System.out.println("The final health levels of wizard_1 and ninja_2 are " +  	wizard_1.health + ", and " + ninja_2.health + ", respectivetly");
		
		System.out.println("\nIII) WIZARD (FIREBALL)\n");
		System.out.println("The initial health levels of wizard_2 and ninja_1 are " +  	wizard_2.health + ", and " + ninja_1.health + ", respectivetly");
				
		System.out.println("wizard_2 trhough fireball to ninja_1"); 
		wizard_2.fireball(ninja_1);
				
		System.out.println("The final health levels of wizard_2 and ninja_1 are " +  	wizard_2.health + ", and " + ninja_1.health + ", respectivetly");
		
		System.out.println("\nIV) NINJA (STEAL AND RUNAWAY)\n");
System.out.println("The initial health levels of ninja_1 and ninja_2 are " +  	ninja_1.health + ", and " + ninja_2.health + ", respectivetly");
		
		System.out.println("ninja_1 steal health of ninja_2"); 
		ninja_1.steal(ninja_2);
		
		System.out.println("The final health levels of ninja_1 and ninja_2 are " +  	ninja_1.health + ", and " + ninja_2.health + ", respectivetly");
		
		System.out.println("ninja_2 runaway");
		ninja_2.runAway();
		System.out.println("The final health levels of ninja_2 is " + ninja_2.health);
		
		System.out.println("\nV) SAMURAI (DEATHBLOW, MEDITATE AND HOWMANY)\n");
		System.out.println("The initial health levels of samurai_1 and wizard_1 are " +  	samurai_1.health + ", and " + wizard_1.health + ", respectivetly");
		
		System.out.println("Samurai_1 use death blow technique over wizard_1");
		samurai_1.deathBlow(wizard_1);
		System.out.println("The final health levels of samurai_1 and wizard_1 are " +  	samurai_1.health + ", and " + wizard_1.health + ", respectivetly");
		
		System.out.println("The initial health levels of samurai_2 is "+ samurai_2.health);
		
		System.out.println("Samurai_2 meditate");
		samurai_2.meditate();
		System.out.println("The final health levels of samurai_2 is "+ samurai_2.health);
		
		System.out.println("Samurai_1 counts how many samurais there are");
		System.out.println("Samurai_1 counts "+ samurai_1.howMany() + " samurais in total");
		
		
	}
}
