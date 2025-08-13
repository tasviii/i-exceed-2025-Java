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

    // method to deposit money into the savings account
    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money from the savings account
    @Override
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

// class representing a fixed deposit bank account
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

    // method to withdraw money, which is not allowed for fixed accounts
    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException("cannot withdraw before maturity");
        // balance -= amount; // this line is unreachable and should be removed
    }

    // method to return the current balance of the fixed account
    @Override
    public double getbalance() {
        return balance;
    }
}

// main class to test the bank account functionality
class program1 {
    public static void main(String asd[]) {

        // creating a savings bank account object
        bankaccount ba = new savingbankaccount(1, 10000);

        // depositing money into savings account
        ba.deposit(1000);

        // printing the balance of savings account
        System.out.println(ba.getbalance());

        // creating a fixed deposit bank account object
        bankaccount fa = new fixedbankaccount(2, 20000);

        // depositing money into fixed account
        fa.deposit(1000);

        // printing the balance of fixed account
        System.out.println(fa.getbalance());

        // trying to withdraw from fixed account (will throw exception)
        fa.withdraw(1000);
    }
}
