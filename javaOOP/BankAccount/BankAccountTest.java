public class BankAccountTest {
   public static void main (String[] args){
        
        BankAccount account_1 = new BankAccount(100,200);
        BankAccount account_2 = new BankAccount(500,0);
        BankAccount account_3 = new BankAccount();


        System.out.println("\nI) The initial amount in each account is the following: \n");
        System.out.println("account_1 -> Account Number: " + account_1.getAccountNumber() + " | Checking Account: " + account_1.getCheckingBalance() + " | Savings Account: " + account_1.getSavingsBalance());
        System.out.println("account_2 -> Account Number: " + account_2.getAccountNumber() + " | Checking Account: " + account_2.getCheckingBalance() + " | Savings Account: " + account_2.getSavingsBalance());
        System.out.println("account_3 -> Account Number: " + account_3.getAccountNumber() + " | Checking Account: " + account_3.getCheckingBalance() + " | Savings Account: " + account_3.getSavingsBalance());
        System.out.println("There are " + BankAccount.getNumberOfAccounts() + " accounts in total");
        System.out.println("Total amount of money in all accounts: " + BankAccount.getTotalAmountInAllBalances());

        System.out.println("\nII) Deposits are done in accounts_1 and account_3 on Savings and Checking accounts: \n");
        System.out.println("Deposit of 100 in Checking Account of account_1 ");
        account_1.depositInCheckingAccount(100);
        System.out.println("Deposit of 300 in Checking Account of account_3 ");
        account_3.depositInCheckingAccount(300);
        System.out.println("Deposit of 300 in Savings Account of account_3 ");
        account_3.depositInSavingsAccount(300);
        System.out.println("account_1 -> Checking Account: " + account_1.getCheckingBalance() + " | Savings Account: " + account_1.getSavingsBalance());
        System.out.println("account_2 -> Checking Account: " + account_2.getCheckingBalance() + " | Savings Account: " + account_2.getSavingsBalance());
        System.out.println("account_3 -> Checking Account: " + account_3.getCheckingBalance() + " | Savings Account: " + account_3.getSavingsBalance());
        System.out.println("Total amount of money in all accounts: " + BankAccount.getTotalAmountInAllBalances());

        System.out.println("\nIII) Withdrawals are done in account_2 on Savings and Checking accounts: \n");
        System.out.println("Withdrawal of 200 in Checking Account of account_2 ");
        account_2.withdrawInCheckingAccount(200);
        System.out.println("Withdrawal of 100 in Savings Account of account_2 ");
        account_2.withdrawInSavingsAccount(100);
        System.out.println("account_1 -> Checking Account: " + account_1.getCheckingBalance() + " | Savings Account: " + account_1.getSavingsBalance());
        System.out.println("account_2 -> Checking Account: " + account_2.getCheckingBalance() + " | Savings Account: " + account_2.getSavingsBalance());
        System.out.println("account_3 -> Checking Account: " + account_3.getCheckingBalance() + " | Savings Account: " + account_3.getSavingsBalance());
        System.out.println("Total amount of money in all accounts: " + BankAccount.getTotalAmountInAllBalances());
   } 
}