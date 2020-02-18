package com.main.nio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;

@EnabledOnOs(OS.LINUX)
class NioUnitTest {

  @Test
  void givenTempDir_whenCallNioApi_thenGetExpectedResults(@TempDir Path tempDir) {
    //tempDir=/tmp/junit1901204880968696330
    assertThatThrownBy(() -> tempDir.getName(5)).isInstanceOf(IllegalArgumentException.class);
    assertThat(tempDir.getNameCount()).isEqualTo(2);
    assertThat(tempDir.getName(0).toString()).isEqualTo("tmp");
    assertThat(tempDir.subpath(0, 1).toString()).isEqualTo("tmp");
    assertThat(tempDir.getName(0).toString()).isEqualTo("tmp");
    assertThat(tempDir.getRoot().toString()).isEqualTo("/");
    assertThat(tempDir.resolveSibling("test").toString()).isEqualTo("/tmp/test");
    assertThat(tempDir).exists();

    var relativePath = Paths.get("tmp/../test.txt");
    assertThat(relativePath.getRoot()).isNull();

    var redundancyPath = Paths.get("/tmp/dir2/../test.txt");
    assertThat(redundancyPath.normalize().toString()).isEqualTo("/tmp/test.txt");

    //relativize
  }
}
