package bankingsystem;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a single bank transaction.
 */
public class Transaction {
  private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Constructs a Transaction.
   *
   * @param type the transaction type
   * @param amount the transaction amount
   * @param initialBalance the balance before transaction
   * @param finalBalance the balance after transaction
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  public double getFinalBalance() {
    return finalBalance;
  }

  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  /**
   * Converts transaction type code to description string.
   *
   * @param type the transaction type code
   * @return the description string
   */
  public static String getTypeString(int type) {
    switch (type) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /**
   * Gets a summary string of this transaction.
   *
   * @return formatted transaction details
   */
  public String getTransactionSummary() {
    logger.info(">>> [LOGGING] summary process started for type: {}", this.type);

    String formattedInitial = String.format(Locale.US, "%.2f", initialBalance);
    String formattedAmount = String.format(Locale.US, "%.2f", amount);
    String formattedFinal = String.format(Locale.US, "%.2f", finalBalance);

    return "- Kiểu giao dịch: " + getTypeString(type)
        + ". Số dư ban đầu: $" + formattedInitial
        + ". Số tiền: $" + formattedAmount
        + ". Số dư cuối: $" + formattedFinal + ".";
  }
}

