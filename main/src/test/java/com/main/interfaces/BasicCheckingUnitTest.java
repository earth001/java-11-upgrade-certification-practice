package com.main.interfaces;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

class BasicCheckingUnitTest {

  @Test
  public void givenValidPin_whenVerifyWithDraw_thenGetResult() {
    Accessible basicChecking = new BasicChecking();

    double result = basicChecking.verifyWithdraw(45, 0);

    assertThat(result).isCloseTo(65, Offset.offset(0.1));
  }
}
