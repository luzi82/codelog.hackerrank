#!/bin/bash

set -e

javac Solution.java
javac Slow.java
javac test.java

cat sample0.txt | java Slow | diff sample0.out.txt -
cat sample1.txt | java Slow | diff sample1.out.txt -
cat sample2.txt | java Slow | diff sample2.out.txt -

cat sample0.txt | java Solution | diff sample0.out.txt -
cat sample1.txt | java Solution | diff sample1.out.txt -
cat sample2.txt | java Solution | diff sample2.out.txt -

cat sample3.txt | java Slow > /tmp/slow.txt
cat sample3.txt | java Solution > /tmp/solution.txt
diff /tmp/slow.txt /tmp/solution.txt

java Test

echo OK
