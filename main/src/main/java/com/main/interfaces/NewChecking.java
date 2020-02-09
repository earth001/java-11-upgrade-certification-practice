package com.main.interfaces;

public class NewChecking implements NewAccessible {

  @Override
  public double verifyDeposit(double amount, int pin) {
    throw new IllegalStateException("Not implemented");
  }
}
