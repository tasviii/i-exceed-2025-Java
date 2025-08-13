// interface defining common operations for all account types
interface iaccount {
    public void deposit(int amt);       // method to deposit money
    public void withdraw(int amt);      // method to withdraw money
    public double getbalance();         // method to get current balance
}

// class representing a savings bank account
class savingbankaccount implements iaccount {
    double balance = 10000; // initial balance for savings account

    // method to deposit money into savings account
    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    // method to withdraw money from savings account
    @Override
    public void withdraw(int amt) {
        balance -= amt;
    }

    // method to return current balance of savings account
    @Override
    public double getbalance() {
        return balance;
    }
}

// class representing a current bank account
class currentaccount implements iaccount {
    double balance = 20000; // initial balance for current account

    // method to deposit money into current account
    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    // method to withdraw money from current account
    @Override
    public void withdraw(int amt) {
        balance -= amt;
    }

    // method to return current balance of current account
    @Override
    public double getbalance() {
        return balance;
    }
}

// class representing a business account
class businessaccount implements iaccount {
    double balance; // initial balance is zero by default

    // method to deposit money into business account
    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    // method to withdraw money from business account
    @Override
    public void withdraw(int amt) {
        balance -= amt;
    }

    // method to return current balance of business account
    @Override
    public double getbalance() {
        return balance;
    }
}

// class providing banking services using dependency injection
class bankservice {
    iaccount iac; // reference to any account type

    // constructor accepting an account object
    bankservice(iaccount iac) {
        this.iac = iac;
    }

    // method to process deposit operation
    public void processdeposit(int amt) {
        iac.deposit(amt);
    }

    // method to process withdrawal operation
    public void processwithdraw(int amt) {
        iac.withdraw(amt);
    }

    // method to get current balance
    public double processbalance() {
        return iac.getbalance();
    }
}

// main class to demonstrate loose coupling using interface
class program4 {
    public static void main(String asd[]) {

        // creating bank service with current account
        bankservice bs = new bankservice(new currentaccount());

        // performing deposit operation
        bs.processdeposit(1000);

        // performing withdrawal operation
        bs.processwithdraw(100);

        // printing the final balance
        System.out.println(bs.processbalance());
    }
}
