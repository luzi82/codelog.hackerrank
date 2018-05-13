#!/bin/bash

set -e

export OUTPUT_PATH=out.txt

javac Solution.java
javac CycleTest.java

java CycleTest

echo sample1

cat sample1.txt | java Solution
diff out.txt sample1.out.txt

echo sample0

cat sample0.txt | java Solution
diff out.txt sample0.out.txt
