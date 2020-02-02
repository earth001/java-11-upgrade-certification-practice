package com.name;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

public class NamesUnitTest {

  @Test
  public void givenName_whenGetName_thenGetExpectedName() {
    String expected = "Duke";

    assertThat(Names.getName()).isEqualTo(expected);
  }
}
