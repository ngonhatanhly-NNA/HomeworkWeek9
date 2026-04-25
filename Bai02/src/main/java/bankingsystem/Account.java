package bankingsystem;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class representing a bank account.
 */
public abstract class Account {
  private static final Logger logger = LoggerFactory.getLogger(Account.class);

  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  protected List<Transaction> transactionList;

  /**
   * Constructs an Account.
   *
   * @param accountNumber the account number
   * @param balance the initial balance
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactionList = new ArrayList<>();
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  /**
   * Sets the transaction list.
   *
   * @param transactionList the list of transactions
   */
  public void setTransactionList(List<Transaction> transactionList) {
    if (transactionList == null) {
      this.transactionList = new ArrayList<>();
    } else {
      this.transactionList = transactionList;
    }
  }

  /**
   * Deposits money into the account.
   *
   * @param amount the amount to deposit
   */
  public abstract void deposit(double amount);

  /**
   * Withdraws money from the account.
   *
   * @param amount the amount to withdraw
   */
  public abstract void withdraw(double amount);

  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  protected void doWithdrawing(double amount)
      throws InvalidFundingAmountException, InsufficientFundsException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  /**
   * Adds a transaction to the history.
   *
   * @param transaction the transaction to add
   */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactionList.add(transaction);
    }
  }

  /**
   * Gets the transaction history as a formatted string.
   *
   * @return the transaction history
   */
  public String getTransactionHistory() {
    StringBuilder builder = new StringBuilder();
    builder.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
    for (int i = 0; i < transactionList.size(); i++) {
      builder.append(transactionList.get(i).getTransactionSummary());
      if (i < transactionList.size() - 1) {
        builder.append("\n");
      }
    }
    logger.debug("Đã lấy lịch sử cho tài khoản: {}", accountNumber);
    return builder.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Account)) {
      return false;
    }
    Account other = (Account) obj;
    return this.accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    return (int) (accountNumber ^ (accountNumber >>> 32));
  }
}

