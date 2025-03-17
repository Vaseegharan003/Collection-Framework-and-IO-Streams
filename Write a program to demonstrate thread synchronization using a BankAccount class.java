class BankAccount {
    private int balance = 1000;
    
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(name + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }
}

class Customer extends Thread {
    private BankAccount account;
    private String name;
    private int amount;
    
    public Customer(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }
    
    public void run() {
        account.withdraw(name, amount);
    }
}

public class BankSyncExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        
        Customer c1 = new Customer(account, "Alice", 700);
        Customer c2 = new Customer(account, "Bob", 500);
        
        c1.start();
        c2.start();
    }
}
