package com.main.interfaces;

import java.util.logging.Logger;

public interface Accessible {

  Logger log = Logger.getLogger(Accessible.class.getName());

  double OVERDRAFT_FEE = 25; /*Default permissions: public static final*/

  public static void showBanner() {
    log.info(customerMessage());
  }

  private static String customerMessage() {
    return "Banner Demo 1.0";
  }

  private boolean login(int pin) {
    return pin == 0;
  }

  double verifyDeposit(double amount, int pin); /*Default permissions: public abstract*/

  default double verifyWithdraw(double amount, int pin) {
    double result;
    log.info(customerMessage());
    if (login(pin)) {
      log.info("Processing login");
      result = amount;
    } else {
      throw new IllegalStateException("Pin inválido");
    }
    return result;
  }
}
