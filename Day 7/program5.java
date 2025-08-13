// interface for deposit-related operations
public interface DepositService {
    void deposit(double amount); // method to deposit money
}

// interface for withdrawal-related operations
public interface WithdrawService {
    void withdraw(double amount); // method to withdraw money
}

// interface for fixed deposit-related operations
public interface FixedDepositService {
    void openFixedDeposit(double amount, int years); // method to open a fixed deposit
}

// interface for credit card-related operations
public interface CreditCardService {
    void issueCreditCard(); // method to issue a credit card
}

// interface for loan-related operations
public interface LoanService {
    void processLoan(); // method to process a loan
}

// class representing a savings account
// implements only the services it actually needs
public class SavingsAccount implements DepositService, WithdrawService, FixedDepositService {

    // method to deposit money into savings account
    @Override
    public void deposit(double amount) {
        System.out.println("deposited " + amount);
    }

    // method to withdraw money from savings account
    @Override
    public void withdraw(double amount) {
        System.out.println("withdrew " + amount);
    }

    // method to open a fixed deposit from savings account
    @Override
    public void openFixedDeposit(double amount, int years) {
        System.out.println("opened fd for " + years + " years");
    }
}

// class representing the credit card department
// implements only the credit card service
public class CreditCardDepartment implements CreditCardService {

    // method to issue a credit card
    @Override
    public void issueCreditCard() {
        System.out.println("credit card issued");
    }
}
