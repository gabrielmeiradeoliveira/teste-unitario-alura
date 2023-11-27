package br.com.tdd.service;

import br.com.tdd.modelo.Desempenho;
import br.com.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void ConsederReajuste(Funcionario funcionario, Desempenho desempenho) {
           BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.desempenho());
           funcionario.setReajusteSalario(reajuste);
    }
}
