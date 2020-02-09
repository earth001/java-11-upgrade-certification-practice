package com.main.interfaces;

public class BasicChecking implements Accessible {

  private static final double BONUS_AMOUNT = 20;

  @Override
  public double verifyDeposit(double amount, int pin) {
    return 0;
  }

  public double verifyWithdraw(double amount, int pin) {
    log.info("BasicChecking: verifyWithdraw");
    return Accessible.super.verifyWithdraw(amount + 20, pin);
  }

}
