import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long stairSum(long v, int d){
        --v;
        v/=d;
        v=v*(v+1)/2;
        v*=d;
        return v;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long n3 = stairSum(n,3);
            long n5 = stairSum(n,5);
            long n15 = stairSum(n,15);
            System.out.println(n3+n5-n15);
        }
    }
}
