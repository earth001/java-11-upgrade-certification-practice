package com.main.interfaces;

public class LastChecking implements Accessible, NewAccessible {


  @Override//Required to solve ambiguity
  public double verifyDeposit(double amount, int pin) {
    return 0;
  }
}
