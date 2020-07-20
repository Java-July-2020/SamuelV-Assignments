
public class Gorilla extends Mammal{
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	public void throwSomething() {
		super.setEnergyLevel(super.getEnergyLevel()-5);
		System.out.println("Grrr, Take this barrel");
	}
	public void eatBananas() {
		super.setEnergyLevel(super.getEnergyLevel()+5);
		System.out.println("Mmmmm, this banana is delicious");
	}
	public void climb() {
		super.setEnergyLevel(super.getEnergyLevel()-10);
		System.out.println("Ufff, I got to the top of the tree!!");
	}
}
