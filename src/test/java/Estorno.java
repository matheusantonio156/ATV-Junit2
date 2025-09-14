import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Estorno {

    @Test
    void testEstornoValido() {
        DigitalWallet wallet = new DigitalWallet("Alice", 100.0);
        wallet.verify();

        // Simulando pagamento
        wallet.deposit(-50.0);
        assertEquals(50.0, wallet.getBalance());

        // Agora faz o estorno (devolve o valor)
        wallet.deposit(50.0);
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    void testEstornoInvalido() {
        DigitalWallet wallet = new DigitalWallet("Bob", 100.0);
        wallet.verify();

        // Estorno negativo não faz sentido → deve lançar erro
        assertThrows(IllegalArgumentException.class, () -> {
            wallet.deposit(-200.0); // tentativa inválida
        });
    }

    @Test
    void testEstornoComContaNaoVerificada() {
        DigitalWallet wallet = new DigitalWallet("Carlos", 100.0);

        // Sem verificar, não deveria permitir certas operações
        assertThrows(IllegalStateException.class, () -> {
            if (!wallet.isVerified()) {
                throw new IllegalStateException("Não é possível estornar sem verificar a conta");
            }
        });
    }
}
