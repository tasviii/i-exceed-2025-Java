// interface defining withdraw functionality
interface withdrawable {
    public void withdraw(int amt); // method to withdraw money
}

// abstract class representing a generic bank account
abstract class bankaccount {
    int accountnumber; // stores the account number
    double balance;    // stores the account balance

    // abstract method to deposit money
    abstract public void deposit(int amount);

    // abstract method to get the current balance
    abstract public double getbalance();
}

// class representing a savings bank account, which supports withdrawal
class savingbankaccount extends bankaccount implements withdrawable {

    // constructor to initialize account number and balance
    savingbankaccount(int accountnumber, double balance) {
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    // method to deposit money into the savings account
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money from the savings account
    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.println("insufficient balance");
        }
    }

    // method to return the current balance of the savings account
    @Override
    public double getbalance() {
        return balance;
    }
}

// class representing a fixed deposit bank account, which does not support withdrawal
class fixedbankaccount extends bankaccount {

    // constructor to initialize account number and balance
    fixedbankaccount(int accountnumber, double balance) {
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    // method to deposit money into the fixed account
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    // method to return the current balance of the fixed account
    @Override
    public double getbalance() {
        return balance;
    }
}

// main class to test the bank account functionality
class program2 {
    public static void main(String asd[]) {

        // creating a savings bank account object
        savingbankaccount ba = new savingbankaccount(1, 10000);

        // depositing money into savings account
        ba.deposit(1000);

        // withdrawing money from savings account
        ba.withdraw(500);

        // printing the balance of savings account
        System.out.println(ba.getbalance());

        // creating a fixed deposit bank account object
        bankaccount fa = new fixedbankaccount(2, 20000);

        // depositing money into fixed account
        fa.deposit(1000);

        // printing the balance of fixed account
        System.out.println(fa.getbalance());
    }
}
