package app;
// ﻿TDE 01 - Classe Salario

// =======================

// - Criar classe "Salario"
// - Criar atributo "salarioBruto" (double)
// - O construtor deve lançar exceção se o salário "que chegar" for menor ou igual a 0
// - Implementar método getSalarioLiquido()

// - Regras - https://www.calculador.com.br/calculo/salario-liquido
//   - Considere sempre 0 dependentes
//   - Considere 0 descontos

// - Postar o arquivo Salario.java em https://www.dropbox.com/request/T2RRECFuRbBFBINwjFSx

// - Para retornar o valor do salário líquido corretamente, use o seguinte:

// .
// .
// .
// BigDecimal salarioLiquido =
//   new BigDecimal(liquido).setScale(2, RoundingMode.HALF_UP);

// return salarioLiquido.doubleValue();

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Salario {
  private Double salarioBruto;
  private BigDecimal salarioLiquido;

  public Salario(Double _salarioBruto) throws Exception {
    if (verificaValor(_salarioBruto)) {
      this.salarioBruto = _salarioBruto;
      setSalarioLiquido(salarioBruto);
    } else {
      throw new Exception("Salario bruto igual ou menor que 0.");
    }
  }

  public Double getSalarioBruto() {
    return this.salarioBruto;
  }

  public void setSalarioBruto(Double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

  public BigDecimal getSalarioLiquido() {
    return salarioLiquido.setScale(2, RoundingMode.HALF_UP);
  }

  public void setSalarioLiquido(Double salarioBruto) {
    this.salarioLiquido = BigDecimal.valueOf(salarioBruto - (salarioBruto * 0.08));
  }

  public boolean verificaValor(Double _salarioBruto) {
    if (_salarioBruto <= 0) {
      return false;
    }
    return true;
  }
}