package com.spanish;

import com.greeting.Salutation;

public class Spanish implements Salutation {
  @Override
  public String getHello() {
    return "Hola";
  }
}
