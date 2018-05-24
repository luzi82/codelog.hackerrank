import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String cal(String[] lineAry){
        BigInteger sumBi = BigInteger.ZERO;
        for(String line:lineAry){
            BigInteger lineBi = new BigInteger(line);
            sumBi = sumBi.add(lineBi);
        }
        return sumBi.toString().substring(0,10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] line=new String[n];
        for(int i=0;i<n;++i){
            line[i] = in.nextLine();
        }
        String ret = cal(line);
        System.out.println(ret);
    }

}
