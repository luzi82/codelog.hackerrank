#!/bin/bash -e

NOW=`date +%s`
TMP_FOLDER=/tmp/UPBBFQFB-${NOW}

rm -rf ${TMP_FOLDER}
mkdir -p ${TMP_FOLDER}

javac Solution.java

cat input.0.txt | java Solution > ${TMP_FOLDER}/output.0.txt
cat input.1.txt | java Solution > ${TMP_FOLDER}/output.1.txt
cat input.2.txt | java Solution > ${TMP_FOLDER}/output.2.txt

diff ${TMP_FOLDER}/output.0.txt expected.0.txt
diff ${TMP_FOLDER}/output.1.txt expected.1.txt
diff ${TMP_FOLDER}/output.2.txt expected.2.txt

echo PASS
