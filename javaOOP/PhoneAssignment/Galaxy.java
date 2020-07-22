public class Galaxy extends Phone implements Ringable {
    
    // I) Class Atributes
    // Attributes from parent class "Phone" are used 

    // II) Class Constructor
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone); // using constructor of parent class
    }
    @Override
    public String ring() {
        String output = "Galaxy says " + this.getRingTone();
        return output;
    }
    @Override
    public String unlock() {
        String output = "Galaxy smartphone unlocked via finger print";
        return output;
    }
    @Override
    public void displayInfo() {
        System.out.println("Version: " + this.getVersionNumber());
        System.out.println("Battery: " + Integer.toString(this.getBatteryPercentage())+"%");
        System.out.println("Carrier: " + this.getCarrier());
        System.out.println("Ring Tone: " + this.getRingTone());              
    }
}
