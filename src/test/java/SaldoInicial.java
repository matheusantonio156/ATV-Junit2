import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaldoInicial {

    @Test
    void testInitialBalance() {
        DigitalWallet wallet = new DigitalWallet("Alice", 100.0);
        assertEquals(100.0, wallet.getBalance());
        assertEquals("Alice", wallet.getOwner());
        assertFalse(wallet.isVerified());
        assertFalse(wallet.isLocked());
    }

    @Test
    void testInitialBalanceNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DigitalWallet("Bob", -50.0);
        });
    }
}
