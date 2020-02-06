module people {
  exports com.name;
  requires transitive header;
  requires com.fasterxml.jackson.databind;
  opens com.name to com.fasterxml.jackson.databind;
}