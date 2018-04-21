#!/bin/bash

set -e

javac Solution.java

cat ../sample0.txt | java Solution
cat ../sample1.txt | java Solution
java Solution xxx
