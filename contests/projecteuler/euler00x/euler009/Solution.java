import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long cal(int n){
        if(n%2!=0)return -1;
        int maxA = (int)Math.ceil(n/(2+Math.sqrt(2)));
        for(int a = maxA;a>0;--a){
            int lhs = n*n - 2*a*n;
            int rhs = 2*n - 2*a;
            if(lhs%rhs!=0)continue;
            int b=lhs/rhs;
            if(b<a)continue;
            int c2 = a*a + b*b;
            int c = (int)Math.sqrt(c2);
            return a*b*c;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long ret = cal(n);
            System.out.println(ret);
        }
    }
}
