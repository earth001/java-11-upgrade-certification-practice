# java-11-upgrade-certification-practice

Sample code to practice for the 1Z0-817 exam

![java-11-upgrade-certification-practice](https://github.com/earth001/java-11-upgrade-certification-practice/workflows/java-11-upgrade-certification-practice/badge.svg)

## Build custom runtime image with jlink

Build: `jlink --module-path people/target/people-0.0.1-SNAPSHOT.jar:conversation/target/conversation-0.0.1-SNAPSHOT.jar:greeting/target/greeting-0.0.1-SNAPSHOT.jar:$JAVA_HOME/jmods --add-modules greeting --output myimage`

Optimize image: `jlink --module-path people/target/people-0.0.1-SNAPSHOT.jar:conversation/target/conversation-0.0.1-SNAPSHOT.jar:greeting/target/greeting-0.0.1-SNAPSHOT.jar:$JAVA_HOME/jmods --add-modules greeting --strip-debug --compress=2 --output myimagecompress` 

Run: `myimage/bin/java -m greeting/com.greeting.Main`

## Migration with jdeps

Show dependencies: ` jdeps -R -summary --module-path conversation/target/conversation-0.0.1-SNAPSHOT.jar:people/target/people-0.0.1-SNAPSHOT.jar greeting/target/greeting-0.0.1-SNAPSHOT.jar`

Generate `module-info.java`: `jdeps --generate-module-info module-info-files lib/* dist/*`

Strategies:

1.- Break cyclic dependencies with split packages and new modules. 
2.- Top-down migration (Migrate application first, libraries latter)
3.- Bottom-up migration (Library first, application latter)