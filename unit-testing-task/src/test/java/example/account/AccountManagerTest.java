package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndCreditNotAllowed_whenWithdraw_thenReturnInsufficient() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);

        // Act
        String result = accountManager.withdraw(customer, 1000);

        // Assert
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    void givenCustomerWithCreditAllowedAndNotVip_whenWithdrawingAboveMaxCredit_thenReturnInsufficient() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(true);

        // Act
        String result = accountManager.withdraw(customer, 2000);

        // Assert
        Assertions.assertEquals("maximum credit exceeded", result);
    }

    @Test
    void givenVipCustomer_whenWithdrawingAboveMaxCredit_thenReturnSuccess() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setVip(true);
        customer.setBalance(500);

        // Act
        String result = accountManager.withdraw(customer, 2000);

        // Assert
        Assertions.assertEquals("success", result);
    }
    @Test
    void givenVipCustomerWithCreditAllowed_whenWithdrawingBelowMaxCredit_thenReturnSuccess() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setCreditAllowed(true);
        customer.setBalance(500);

        // Act
        String result = accountManager.withdraw(customer, 1000);

        // Assert
        Assertions.assertEquals("success", result);
    }
    @Test
    void givenCustomerWithBalance_whenDepositAmount_thenBalanceIncreases() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(1000);

        // Act
        accountManager.deposit(customer, 500);

        // Assert
        Assertions.assertEquals(1500, customer.getBalance());
    }
}
