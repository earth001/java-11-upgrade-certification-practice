package com.main.interfaces;

import java.util.logging.Logger;

public interface NewAccessible extends Accessible {

  default double verifyWithdraw(double amount, int pin) {
    throw new IllegalStateException("Not implemented");
  }
}
