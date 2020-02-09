package com.main.interfaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class DoubleCheckingUnitTest {

  @Test
  public void givenValidPin_whenVerifyWithDraw_thenGetResult() {
    Accessible doubleChecking= new DoubleChecking();

    double result = doubleChecking.verifyWithdraw(45, 0);

    assertThat(result).isCloseTo(65, Offset.offset(0.1));
  }
}