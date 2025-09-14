import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class Deposito {

    @Test
    void testDepositValid() {
        DigitalWallet wallet = new DigitalWallet("Alice", 100.0);
        wallet.deposit(50.0);
        assertEquals(150.0, wallet.getBalance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -10.0, -100.0})
    void testDepositInvalid(double invalidAmount) {
        DigitalWallet wallet = new DigitalWallet("Alice", 100.0);
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.deposit(invalidAmount);
        });
    }
}
