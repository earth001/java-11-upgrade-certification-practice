package com.greating;

import com.name.Names;
import com.question.Questions;
import java.util.logging.Logger;

public class Main {

  private static final Logger log = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    log.info(String.format("Hello %s, %s", Names.getName(), Questions.getQuestion()));
  }
}
