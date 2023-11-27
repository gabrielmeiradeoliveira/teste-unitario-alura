import br.com.tdd.modelo.Funcionario;
import br.com.tdd.service.ReajusteService;
import br.com.tdd.modelo.Desempenho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajuste;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.reajuste = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteSalario_reajusteDeTresPorcendoQunadoDesenpenhoForADesejar() {
        reajuste.ConsederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteSalario_reajusteDeTresPorcendoQunadoDesenpenhoForBom() {
        reajuste.ConsederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteSalario_reajusteDeTresPorcendoQunadoDesenpenhoForOtimo() {
        reajuste.ConsederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
