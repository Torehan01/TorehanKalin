import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private String accountType;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getter and Setter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class Customer {
    private int customerId;
    private String name;
    private String email;
    private BankAccount account;

    // Constructor
    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getter and Setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                '}';
    }
}

class Bank {
    private String name;
    private List<Customer> customers;

    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Methods
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}

public class OnlineBankingApp {
    public static void main(String[] args) {
        // Create bank
        Bank bank = new Bank("MyBank");

        // Create customers
        Customer customer1 = new Customer(1, "Alice", "alice@example.com");
        Customer customer2 = new Customer(2, "Bob", "bob@example.com");

        // Create accounts
        BankAccount account1 = new BankAccount("1001", "Savings", 500.0);
        BankAccount account2 = new BankAccount("1002", "Checking", 1000.0);

        // Link accounts to customers
        customer1.setAccount(account1);
        customer2.setAccount(account2);

        // Add customers to bank
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        // Perform operations
        account1.deposit(200);
        account1.withdraw(100);

        account2.deposit(500);
        account2.withdraw(2000); // Insufficient funds

        // Output customer and account details
        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println(bank);
    }
}
