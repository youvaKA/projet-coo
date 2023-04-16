all: test

competition: competition
	javac src/Main.java src/competitions/*.java src/competitions/competitors/*.java src/competitions/strategies/*.java src/competitions/matches/*.java src/competitions/utiles/*.java -sourcepath src -d classes

#NON FONCTIONNEL
jar: jar
	jar cfm competition.jar META-INF/MANIFEST.MF classes/competitions/*.class classes/observers/*.class classes/competitions/competitors/*.class classes/competitions/matches/*.class classes/Main.class

test: test
	javac -d classes -cp ./lib/*.jar ./tests/*.java ./src/Main.java ./src/competitions/strategies/*.java ./src/competitions/observers/*.java ./src/competitions/*.java ./src/competitions/competitors/*.java ./src/competitions/matches/*.java ./src/competitions/utiles/*java

runtest: runtest
	java -jar ./lib/junit-platform-console-standalone-1.9.0.jar -cp classes --scan-classpath --disable-banner

clean:
	rm -rf classes

.PHONY: all test clean
