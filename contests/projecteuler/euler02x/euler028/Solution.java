import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public final static long BIG = 1000000007;
    public final static BigInteger SIX = BigInteger.valueOf(6);
    public final static BigInteger BIGB = BigInteger.valueOf(BIG);;

    public static long sub(long a,long b){
        if(a<b)a+=BIG;
        return a-b;
    }

    public static long mult(long a,long b){
        long ans=a*b;
        return ans%BIG;
    }

    public static long x2(long v){
        BigInteger ans = BigInteger.valueOf(v);
        ans = ans.multiply(BigInteger.valueOf(v+1));
        ans = ans.multiply(BigInteger.valueOf(2*v+1));
        ans = ans.divide(SIX);
        ans = ans.remainder(BIGB);
        return ans.longValue();
    }

    public static long x1(long v){
        long ans = v;
        ans *= v+1;
        ans /= 2;
        return ans%BIG;
    }

    public static long getAns(long n){
        if(n==1)return 1;

        long x28 = x2((n+1)%BIG);
        long x24 = x2(((n+1)/2)%BIG);
        long x13 = x1(((n-1)/2)%BIG);

        long ans = mult(4,x28);
        ans = sub(ans,mult(16,x24));
        ans = sub(ans,mult(12,x13));
        ans = sub(ans,3);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;++i){
            long n = scanner.nextLong();
            long ans = getAns(n);
            System.out.println(ans);
        }
    }
}