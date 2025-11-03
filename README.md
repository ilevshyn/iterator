Requirements:
JDK 25 and GraalVM 25

Usage (with jpackage):
1) Use JDK 25
1.5) Make sure /build/jpackage is empty!
2) Execute from project root:
```./gradlew packageApp```
3) App will be built in /build/package/itx/bin
4) Use using
```./itx mode file```
where mode is:
c - iterate over characters;
w - over words;
s - over sentences;
n - over numbers;
r - over custom regex;

file is optional.

With GraalVM native image:
1) Use GraalVM 25
2) Execute from project root:
```./gradlew nativeCompile```
3) Native image will be in /build/native/nativeCompile
4) Usage same in jpackage but
```./iterator mode file```
