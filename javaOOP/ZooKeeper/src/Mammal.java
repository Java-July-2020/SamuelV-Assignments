
public class Mammal {
	private int energyLevel;
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
