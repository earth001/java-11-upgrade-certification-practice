package com.main.interfaces;

public interface NewAccessible extends Accessible {

  default double verifyWithdraw(double amount, int pin) {
    throw new IllegalStateException("Not implemented");
  }
}
