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
  private Double salarioLiquido;

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
    // return salarioLiquido.doubleValue();

    BigDecimal salarioLiquido = new BigDecimal(this.salarioLiquido).setScale(2, RoundingMode.HALF_UP);

    return salarioLiquido.setScale(2, RoundingMode.HALF_UP);
  }

  public void setSalarioLiquido(Double salarioBruto) {
    // calculo INSS
    if (salarioBruto <= 1751.81) {
      this.salarioLiquido = salarioBruto - (salarioBruto * 0.08);
    } else if (salarioBruto >= 1751.81 && salarioBruto <= 2919.72) {
      this.salarioLiquido = salarioBruto - (salarioBruto * 0.09);
    } else {
      this.salarioLiquido = salarioBruto - (salarioBruto * 0.11);
    }

    // calcular IRRF
    if (salarioLiquido >= 1903.99 && salarioLiquido <= 2826.65) {
      this.salarioLiquido -= ((salarioLiquido * 0.075) - 142.8);
    } else if (salarioLiquido >= 2826.66 && salarioLiquido <= 3751.05) {
      this.salarioLiquido -= ((salarioLiquido * 0.15) - 354.8);
    } else if (salarioLiquido >= 3751.06 && salarioLiquido <= 4664.68) {
      this.salarioLiquido -= ((salarioLiquido * 0.225) - 636.13);
    } else if (salarioLiquido > 4664.68) {
      this.salarioLiquido -= ((salarioLiquido * 0.275) - 869.36);
    }

  }

  public boolean verificaValor(Double _salarioBruto) {
    if (_salarioBruto <= 0) {
      return false;
    }
    return true;
  }

}