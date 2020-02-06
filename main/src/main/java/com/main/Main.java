package com.main;

import com.greeting.Salutation;
import com.header.Headers;
import com.name.NameFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ServiceLoader;
import java.util.logging.Logger;

public class Main {

  private static final Logger log = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) throws IOException, URISyntaxException {
    var salutations = ServiceLoader.load(Salutation.class);
    log.info(Headers.getHeader());
    var factory = new NameFactory("names.json");
    for (var salutation : salutations) {
      for (var name : factory.getNames()) {
        log.info(
            String.format("%s %s", salutation.getHello(), name.getName()));
      }
    }
  }
}
