public class IPhone extends Phone implements Ringable {
    
    // I) Class Atributes
    // Attributes from parent class "Phone" are used 

    // II) Class Constructor
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone); // using constructor of parent class
    }

    
    @Override
    public String ring() {
        String output = "iPhone says " + this.getRingTone();
        return output;
    }
    @Override
    public String unlock() {
        String output = "iPhone unlocked via facial recognition";
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
