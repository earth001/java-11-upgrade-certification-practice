package com.name;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NameFactory {
  private final String datasource;

  public NameFactory(String datasource) {
    this.datasource = datasource;
  }

  public List<Name> getNames() throws IOException, URISyntaxException {
    var input = Files.readString(Paths.get(ClassLoader.getSystemResource(datasource).toURI()),
        StandardCharsets.UTF_8);
    var mapper = new ObjectMapper();
    return mapper.readValue(input, new TypeReference<>() {
    });
  }
}
