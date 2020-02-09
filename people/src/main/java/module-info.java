module people {
  exports com.name;
  requires transitive header;
  requires com.fasterxml.jackson.databind;
  requires java.logging;
  opens com.name to com.fasterxml.jackson.databind;
}