import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void calcularBonus_retornaZeroParaSalariosAltos() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class ,
                () -> bonusService.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal(25000))));
    }

    @Test
    void calcularBonus_bonusDeDezPorcentoNoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    void calcularBonus_bonusDeveriaSerDezPorcentoParaExatamenteDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Carlos", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}
