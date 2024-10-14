package model.Demo;

import model.Exception.DomainException;

public class Conta {
  private Integer number;
  private String holder;
  private double saldo;
  private double retiradaLimite;

  public Conta() {}

  public Conta(Integer number, String holder, double saldo, double retiradaLimite) {
    if (saldo < 0 || retiradaLimite < 0) {
      throw new DomainException("Saldo e limite de retirada não podem ser negativos");
    }
    this.number = number;
    this.holder = holder;
    this.saldo = saldo;
    this.retiradaLimite = retiradaLimite;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getHolder() {
    return holder;
    
  }

  public void setHolder(String holder) {
    this.holder = holder;
  }

  public double getSaldo() {
    return saldo;
  }

  public double getRetiradaLimite() {
    return retiradaLimite;
  }

  public void setRetiradaLimite(double retiradaLimite) {
    if (retiradaLimite <= 0) {
      throw new DomainException("Limite de retirada não pode ser negativo");
    }
    this.retiradaLimite = retiradaLimite;
  }

  public void deposit(double amount) {
    if (amount <= 0) {
      throw new DomainException("O depósito deve ser maior que zero");
    }
    saldo += amount;
  }

  public void withdraw(double amount) {

    if (saldo == 0) {
      throw new DomainException("Não há saldo na conta");
    }
    if (amount > retiradaLimite) {
      throw new DomainException("Valor do saque superior ao limite de saque da conta");
    }
    if (amount>saldo) {
      throw new DomainException("Saldo insuficiente para a retirada");
    }
    saldo -= amount;
  }
}
