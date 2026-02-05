#!/bin/bash
rm -f output 2>&1 >/dev/null
javac *.java
cp original.txt titles.txt
java LibraryManager > output
javac Testing.java
java Testing 18 output.reference output