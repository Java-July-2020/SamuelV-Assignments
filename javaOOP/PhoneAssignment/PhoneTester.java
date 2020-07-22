public class PhoneTester {
    public static void main(String[] args){
        
        Galaxy s9 = new Galaxy("S9",99,"Verizon","Ring Ring Ring!");
        IPhone iphoneTen = new IPhone("X",100,"AT&T","Zing");

        // Displaying info of Galaxy S9
        System.out.println("\nI) Displaying Info of Galaxy S9:");
        s9.displayInfo();
        System.out.println("\nII) Galaxy S9 ringing!!!!");
        System.out.println(s9.ring());
        System.out.println(s9.unlock());
        
        // Displaying info of Galaxy S9
        System.out.println("\nIII) Displaying Info of iPhone X:");
        iphoneTen.displayInfo();
        System.out.println("\nIV) iPhone X ringing!!!!");
        System.out.println(iphoneTen.ring());
        System.out.println(iphoneTen.unlock());

       
    }
}