import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class Pagamento {

    @Test
    void testPagamentoAssumeTrue() {
        DigitalWallet wallet = new DigitalWallet("Alice", 200.0);
        wallet.verify();

        // só roda o teste se a carteira estiver verificada
        assumeTrue(wallet.isVerified(), "Carteira não verificada, teste ignorado");

        wallet.deposit(100.0);
        assertEquals(300.0, wallet.getBalance());
    }

    @Test
    void testPagamentoAssumeFalse() {
        DigitalWallet wallet = new DigitalWallet("Bob", 200.0);

        // só roda se a carteira NÃO estiver verificada
        assumeFalse(wallet.isVerified(), "Carteira verificada, teste ignorado");

        assertThrows(IllegalStateException.class, () -> {
            // exemplo: tentativa de pagamento sem verificar
            if (!wallet.isVerified()) {
                throw new IllegalStateException("Não é possível pagar sem verificar a conta");
            }
        });
    }

    @ParameterizedTest
    @CsvSource({
        "50.0, 150.0",
        "100.0, 100.0",
        "200.0, 0.0"
    })
    void testPagamentoComCsv(double pagamento, double saldoEsperado) {
        DigitalWallet wallet = new DigitalWallet("Carlos", 200.0);
        wallet.verify();

        wallet.deposit(-pagamento); // simulando pagamento como "saída"
        assertEquals(saldoEsperado, wallet.getBalance());
    }
}
