

public class BankAccount {

    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalAmountInAllBalances = 0;

    public BankAccount(double checkingBalance, double savingsBalance){
        this.accountNumber = this.randomDigitAccountNumber();
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        totalAmountInAllBalances += checkingBalance + savingsBalance;
    }

    public BankAccount(){
        this(0,0);
    }

    // PUBLIC METHODS FOR INSTANCES OF THE CLASS
    
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public void depositInCheckingAccount(double amount){
        this.checkingBalance += amount;
        totalAmountInAllBalances += amount;
    }
    
    public void withdrawInCheckingAccount(double amount){
        if (amount <= this.checkingBalance){
            this.checkingBalance -= amount;
            totalAmountInAllBalances -= amount;
        }
        else{
            System.out.println("You exceed the maximum amount you have in your Checking Account. Operation denied!");
        }
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void depositInSavingsAccount(double amount){
        this.savingsBalance += amount;
        totalAmountInAllBalances += amount;
    }

    public void withdrawInSavingsAccount(double amount){
        if (amount <= this.savingsBalance){
            this.savingsBalance -= amount;
            totalAmountInAllBalances -= amount;
        }
        else{
            System.out.println("You exceed the maximum amount you have in your Savings Account. Operation denied!");
        }
    }

    // PUBLIC STATIC METHODS FROM THE CLASS
    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public static double getTotalAmountInAllBalances(){
        return totalAmountInAllBalances;
    }

    // PRIVATE METHODS FOR INSTANCES OF THE CLASS
    private String randomDigitAccountNumber(){
       
        String NumericChars =  "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(10); 
  
        for (int i = 0; i < 10; i++) { 
   
            int index = (int) (NumericChars.length() * Math.random()); 
            // add Character one by one in end of sb 
            sb.append(NumericChars .charAt(index)); 
        } 
  
        String randomAccountNumber =  sb.toString();
        return randomAccountNumber;
    }

}