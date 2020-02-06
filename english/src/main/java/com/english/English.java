package com.english;


import com.greeting.Salutation;

public class English implements Salutation {
  @Override
  public String getHello() {
    return "Hi";
  }
}
