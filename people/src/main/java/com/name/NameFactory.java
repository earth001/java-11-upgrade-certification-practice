package com.name;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

public class NameFactory implements Factory {

  private static final Logger log = Logger.getLogger(NameFactory.class.getName());
  private final String datasource;

  public NameFactory(String datasource) {
    this.datasource = datasource;
  }

  public List<Name> getNames() throws IOException, URISyntaxException {

    log.info("getNames from Java 11");
    var input = new String(
        getClass().getResourceAsStream(
            String.format("%c%s", File.separatorChar, datasource)).readAllBytes(),
        StandardCharsets.UTF_8);
    var mapper = new ObjectMapper();
    return mapper.readValue(input, new TypeReference<>() {
    });
  }
}
