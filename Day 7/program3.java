// class representing a savings bank account
class savingbankaccount {
    int balance; // stores the balance of the savings account

    // method to deposit money into savings account
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money from savings account
    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.println("insufficient balance");
        }
    }

    // method to return the current balance of savings account
    public double getbalance() {
        return balance;
    }
}

// class representing a current bank account
class currentaccount {
    int balance; // stores the balance of the current account

    // method to deposit money into current account
    public void deposit(int amount) {
        balance += amount;
    }

    // method to withdraw money from current account
    public void withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
        } else {
            System.out.println("insufficient balance");
        }
    }

    // method to return the current balance of current account
    public double getbalance() {
        return balance;
    }
}

// class providing banking services for savings and current accounts
class bankservice {
    savingbankaccount sb = new savingbankaccount(); // savings account object
    currentaccount ca = new currentaccount();       // current account object

    // constructor initializing savings and current account objects
    bankservice() {
        this.sb = sb;
        this.ca = ca;
    }

    // method to deposit money into savings account
    public void depositetosaving(int amt) {
        sb.deposit(amt);
    }

    // method to withdraw money from savings account
    public void withdrawfromsaving(int amt) {
        sb.withdraw(amt);
    }

    // method to get balance from savings account
    public double getbalancefromsaving() {
        return sb.getbalance();
    }

    // method to deposit money into current account
    public void depositetocurrent(int amt) {
        ca.deposit(amt);
    }

    // method to withdraw money from current account
    public void withdrawfromcurrent(int amt) {
        ca.withdraw(amt);
    }
}

// main class to test the banking service
class program3 {
    public static void main(String asd[]) {

        // creating bank service object
        bankservice bs = new bankservice();

        // depositing money into savings account
        bs.depositetosaving(10000);

        // withdrawing money from savings account
        bs.withdrawfromsaving(1000);

        // printing balance of savings account
        System.out.println(bs.getbalancefromsaving());
    }
}
