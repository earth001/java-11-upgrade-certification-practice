package com.main.interfaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NewCheckingUnitTest {

  @Test
  public void givenValidPin_whenVerifyWithDraw_thenThrowsException() {
    Accessible newChecking = new NewChecking();

    assertThatThrownBy(() -> newChecking.verifyWithdraw(45, 0))
        .isInstanceOf(IllegalStateException.class).hasMessageContaining("Not implemented");
  }
}