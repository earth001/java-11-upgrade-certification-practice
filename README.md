# java-11-upgrade-certification-practice

Sample code to practice for the 1Z0-817 exam

![java-11-upgrade-certification-practice](https://github.com/earth001/java-11-upgrade-certification-practice/workflows/java-11-upgrade-certification-practice/badge.svg)

## Build custom runtime image with jlink

Build: `jlink --module-path people/target/people-0.0.1-SNAPSHOT.jar:conversation/target/conversation-0.0.1-SNAPSHOT.jar:greeting/target/greeting-0.0.1-SNAPSHOT.jar:$JAVA_HOME/jmods --add-modules greeting --output myimage`

Optimize image: `jlink --module-path people/target/people-0.0.1-SNAPSHOT.jar:conversation/target/conversation-0.0.1-SNAPSHOT.jar:greeting/target/greeting-0.0.1-SNAPSHOT.jar:$JAVA_HOME/jmods --add-modules greeting --strip-debug --compress=2 --output myimagecompress` 

Run: `myimage/bin/java -m greeting/com.greeting.Main`

