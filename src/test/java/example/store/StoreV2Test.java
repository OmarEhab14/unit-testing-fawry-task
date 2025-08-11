package example.store;

import example.account.AccountManager;
import example.account.AccountManagerImpl;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StoreV2Test {

    @Test
    void givenProductInStockAndWithdrawalSuccess_whenBuy_thenQuantityDecreases() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(3, product.getQuantity());
    }

    @Test
    void givenProductOutOfStock_whenBuy_thenThrowException() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(0);
        Customer customer = new Customer();

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });
    }

    @Test
    void givenProductInStockAndWithdrawalFailure_whenBuy_thenThrowException() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("failure");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act & Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });
    }

}
