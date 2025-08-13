// abstract class representing a generic bank account
abstract class bankaccount {
    int accountnumber; // stores the account number
    double balance;    // stores the account balance

    // abstract method to deposit money
    abstract public void deposit(int amount);

    // abstract method to withdraw money
    abstract public void withdraw(int amount);

    // abstract method to get the current balance
    abstract public double getbalance();
}

// class representing a savings bank account
class savingbankaccount extends bankaccount {

    // constructor to initialize account number and balance
    savingbankaccount(int accountnumber, double balance) {
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    // method to deposit money into the account
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money from the account
    @Override
    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.println("insufficient balance");
        }
    }

    // method to return the current balance
    @Override
    public double getbalance() {
        return balance;
    }
}

// class representing a fixed deposit bank account
class fixedbankaccount extends bankaccount {

    // constructor to initialize account number and balance
    fixedbankaccount(int accountnumber, double balance) {
        this.accountnumber = accountnumber;
        this.balance = balance;
    }

    // method to deposit money into the account
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money, which is not supported for fixed accounts
    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException(); // corrected exception name
        // balance -= amount; // this line is unreachable and should be removed
    }

    // method to return the current balance
    @Override
    public double getbalance() {
        return balance;
    }
}
