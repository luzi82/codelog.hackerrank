#!/bin/bash

set -e

javac Solution.java

java Solution xxx
cat sample.txt | java Solution
