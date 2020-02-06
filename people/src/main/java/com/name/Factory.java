package com.name;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface Factory {
  List<Name> getNames()  throws IOException, URISyntaxException;
}
