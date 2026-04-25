package bankingsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Checking account implementation.
 */
public class CheckingAccount extends Account {

  private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, amount,
          initialBalance, finalBalance);
      addTransaction(t);
    } catch (BankException e) {
      logger.error("Lỗi khi nạp tiền vào tài khoản vãng lai: {}", e.getMessage(), e);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, amount,
          initialBalance, finalBalance);
      addTransaction(t);
    } catch (BankException e) {
      logger.error("Lỗi khi rút tiền từ tài khoản vãng lai: {}", e.getMessage(), e);
    }
  }
}

