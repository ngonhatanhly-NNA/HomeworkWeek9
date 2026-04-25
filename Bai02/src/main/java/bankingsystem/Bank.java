package bankingsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a bank with customers and accounts.
 */
public class Bank {
  private static final Logger logger = LoggerFactory.getLogger(Bank.class);
  private static final String ID_REGEX = "\\d{9}";

  private List<Customer> customerList;

  public Bank() {
    this.customerList = new ArrayList<Customer>();
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * Sets the customer list.
   *
   * @param customerList the list of customers
   */
  public void setCustomerList(List<Customer> customerList) {
    if (customerList == null) {
      this.customerList = new ArrayList<>();
    } else {
      this.customerList = customerList;
    }
  }

  /**
   * Reads customer data from an input stream.
   *
   * @param inputStream the input stream containing customer data
   */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      logger.warn("InputStream truyền vào bị null, hủy bỏ tác vụ đọc dữ liệu.");
      return;
    }

    logger.debug("Bắt đầu đọc dữ liệu khách hàng...");
    Customer currentCustomer = null;

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();

        if (line.isEmpty()) {
          logger.warn("Dòng dữ liệu trống: '{}'", line);
          continue;
        }

        int lastSpaceIndex = line.lastIndexOf(' ');
        if (lastSpaceIndex <= 0) {
          logger.warn("Dòng dữ liệu không hợp lệ (không tìm thấy khoảng trắng): '{}'",
              line);
          continue;
        }

        String token = line.substring(lastSpaceIndex + 1).trim();

        if (token.matches(ID_REGEX)) {
          String name = line.substring(0, lastSpaceIndex).trim();
          currentCustomer = new Customer(Long.parseLong(token), name);
          customerList.add(currentCustomer);
          logger.info("Đã thêm khách hàng: {}", name);
        } else if (currentCustomer != null) {
          parseAndAddAccount(line, currentCustomer);
        }
      }
    } catch (IOException e) {
      logger.error("Lỗi I/O khi đọc dữ liệu khách hàng: {}", e.getMessage(), e);
    }
  }

  private void parseAndAddAccount(String line, Customer customer) {
    String[] parts = line.split("\\s+");
    if (parts.length < 3) {
      logger.warn("Dòng dữ liệu tài khoản không hợp lệ: '{}'", line);
      return;
    }

    try {
      String accountType = parts[0].toLowerCase();
      long accountNumber = Long.parseLong(parts[1]);
      double balance = Double.parseDouble(parts[2]);

      if (Account.CHECKING_TYPE.equals(accountType)) {
        customer.addAccount(new CheckingAccount(accountNumber, balance));
      } else if (Account.SAVINGS_TYPE.equals(accountType)) {
        customer.addAccount(new SavingsAccount(accountNumber, balance));
      } else {
        logger.warn("Loại tài khoản không hợp lệ: {}", accountType);
      }
    } catch (NumberFormatException e) {
      logger.error("Lỗi định dạng số liệu tài khoản ở dòng: {}", line, e);
    }
  }

  /**
   * Gets customer info sorted by ID.
   *
   * @return formatted customer list string
   */
  public String getCustomersInfoByIdOrder() {
    customerList.sort(Comparator.comparing(Customer::getIdNumber));
    return formatCustomerList(customerList);
  }

  /**
   * Gets customer info sorted by name, then by ID.
   *
   * @return formatted customer list string
   */
  public String getCustomersInfoByNameOrder() {
    List<Customer> copyList = new ArrayList<>(customerList);
    copyList.sort(Comparator.comparing(Customer::getFullName)
        .thenComparingLong(Customer::getIdNumber));
    return formatCustomerList(copyList);
  }

  /**
   * Formats a customer list into a string.
   *
   * @param list the customer list
   * @return formatted string
   */
  private String formatCustomerList(List<Customer> list) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      builder.append(list.get(i).getCustomerInfo());
      if (i < list.size() - 1) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }
}

