package bankingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank customer.
 */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /**
   * Default constructor.
   */
  public Customer() {
    this(0L, "");
  }

  /**
   * Constructs a Customer.
   *
   * @param idNumber the ID number
   * @param fullName the full name
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<Account>();
  }

  public long getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public List<Account> getAccountList() {
    return accountList;
  }

  /**
   * Sets the account list.
   *
   * @param accountList the list of accounts
   */
  public void setAccountList(List<Account> accountList) {
    if (accountList == null) {
      this.accountList = new ArrayList<Account>();
    } else {
      this.accountList = accountList;
    }
  }

  /**
   * Adds an account for this customer.
   *
   * @param account the account to add
   */
  public void addAccount(Account account) {
    if (account == null) {
      return;
    }
    if (!accountList.contains(account)) {
      accountList.add(account);
    }
  }

  /**
   * Removes an account from this customer.
   *
   * @param account the account to remove
   */
  public void removeAccount(Account account) {
    if (account == null) {
      return;
    }
    accountList.remove(account);
  }

  /**
   * Gets customer info as text.
   *
   * @return formatted customer info
   */
  public String getCustomerInfo() {
    return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
  }
}

