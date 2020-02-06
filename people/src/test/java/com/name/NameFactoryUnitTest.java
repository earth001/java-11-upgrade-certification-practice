package com.name;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;

public class NameFactoryUnitTest {

  @Test
  public void givenFileWithJsonValues_whenReadValue_getListWithData()
      throws URISyntaxException, IOException {
    var factory = new NameFactory("names.json");

    var names = factory.getNames();

    assertThat(names).hasSize(4);
  }
}
