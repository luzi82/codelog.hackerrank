#!/bin/bash

set -e

javac Solution.java

cat ../sample.txt | java Solution
