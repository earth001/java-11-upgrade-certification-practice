package com.name;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NameFactory implements Factory {
  private final String datasource;

  public NameFactory(String datasource) {
    this.datasource = datasource;
  }

  public List<Name> getNames() throws IOException, URISyntaxException {
    System.out.println("getNames from Java 10");
    var input = new String(
        Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(datasource).toURI())),
        StandardCharsets.UTF_8);
    var mapper = new ObjectMapper();
    return mapper.readValue(input, new TypeReference<>() {
    });
  }
}
