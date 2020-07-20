
public class GorillaTest {

	public static void main(String[] args) {
		Gorilla DK = new Gorilla(500);
		
		System.out.println("The initial energy level of DK is: "+ DK.getEnergyLevel());
		
		DK.throwSomething();
		DK.throwSomething();
		DK.throwSomething();
		DK.eatBananas();
		DK.eatBananas();
		DK.climb();
		
		System.out.println("The finaleEnergy level of DK is: "+ DK.getEnergyLevel());
	}

}
