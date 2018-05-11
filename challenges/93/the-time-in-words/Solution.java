import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static final String[] NUMBER_TXT = {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "twenty",
        "twenty one",
        "twenty two",
        "twenty three",
        "twenty four",
        "twenty five",
        "twenty six",
        "twenty seven",
        "twenty eight",
        "twenty nine"
    };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
    
        int hh=(h+1)%12;
        if(h==0)h=12;
        if(hh==0)hh=12;

        if(m==0)  return String.format("%s o' clock", NUMBER_TXT[h]);
        if(m==1)  return String.format("%s minute past %s", NUMBER_TXT[m], NUMBER_TXT[h]);
        if(m==15) return String.format("quarter past %s", NUMBER_TXT[h]);
        if(m==30) return String.format("half past %s", NUMBER_TXT[h]);
        if(m==45) return String.format("quarter to %s", NUMBER_TXT[hh]);
        if(m==59) return String.format("%s minute to %s", NUMBER_TXT[60-m], NUMBER_TXT[hh]);
        if(m>30)  return String.format("%s minutes to %s", NUMBER_TXT[60-m], NUMBER_TXT[hh]);
        return String.format("%s minutes past %s", NUMBER_TXT[m], NUMBER_TXT[h]);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
