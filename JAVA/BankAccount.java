import java.util.*;

interface Account {
    void accountOpen(); 
    void accountClose(); 
}

// Abstract class for bank details
abstract class BankDetail {
    private String bankName;
    private String branchName;
    private String accountType;
    private int accountNumber;
    double amount; 

    public BankDetail(String bankName, String branchName, String accountType, int accountNumber, double amount) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public abstract void checkAccountBalance();

    public void display() {
        System.out.println("Bank Details: bankName:- " + bankName + " branchName:- " + branchName + " accountType:- " + accountType + " accountNumber:- " + accountNumber);
    }
}

//  class implementing Account interface
class Bank extends BankDetail implements Account {
    private boolean isBankAccountExist = true; 

    public Bank(String bankName, String branchName, String accountType, int accountNumber, double amount) {
        super(bankName, branchName, accountType, accountNumber, amount);
    }

    // Method to close account
    public void accountClose() {
        if (isBankAccountExist) {
            isBankAccountExist = false;
            System.out.println("Your bank account is now closed.");
        }
    }

    // Method to open account
    public void accountOpen() {
        if (!isBankAccountExist) {
            isBankAccountExist = true;
            System.out.println("You have opened a bank account.");
        } else {
            System.out.println("Your bank account already exists.");
        }
    }

    public void checkAccountBalance() {
        if (amount > 0) {
            System.out.println("Account balance is:- " + amount);
        } else {
            System.out.println("You don't have sufficient account balance.");
        }
    }
}

// Abstract class for transaction operations
abstract class Transaction {
    float totalAmount; 

    public Transaction(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public abstract void debit(float Amount);
    public abstract void credit(float Amount);
}

// Class for transaction details implementation
class TransactionDetail extends Transaction {

    public TransactionDetail(float totalAmount) {
        super(totalAmount);
    }

    // Method to credit amount
    public void credit(float Amount) {
        System.out.println(Amount + " :- Amount is credited to your account.");
        totalAmount += Amount; // Update total amount
        System.out.println("Your Balance is now:- " + totalAmount);
    }

    // Method to debit amount
    public void debit(float Amount) {
        if (Amount <= totalAmount) {
            System.out.println(Amount + " :- Amount is debited from your account.");
            totalAmount -= Amount; 
            System.out.println("Your Balance is now:- " + totalAmount);
        } else {
            System.out.println("Insufficient funds for this transaction.");
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {

        System.out.println("-----------------------------------------");

        Bank obj = new Bank("KOTAK", "Soni ni chal", "Savings", 94757478, 10000);
        obj.display();
        obj.checkAccountBalance();
        obj.accountClose();
        obj.accountOpen();

        System.out.println("-----------------------------------------");

        TransactionDetail obj2 = new TransactionDetail(30000); // Initialize balance
        obj2.credit(2000); 
        obj2.debit(1000);  
    }
}
