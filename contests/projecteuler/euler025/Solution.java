import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    static BigInteger a = BigInteger.ONE;
    static BigInteger b = BigInteger.ONE;
    static int bOrder = 2;

    static int[] cacheAnsAry = new int[5010];
    static int cacheAnsAryDone;
    static BigInteger t = BigInteger.TEN;
    static {
        cacheAnsAry[0]=0;
        cacheAnsAry[1]=1;
        cacheAnsAryDone=2;
    }

    public static int getAns(int n){
        while(cacheAnsAryDone<=n){
            while(true){
                BigInteger c = a.add(b);
                a = b;
                b = c;
                ++bOrder;
                if(b.compareTo(t)>=0)
                    break;
            }
            cacheAnsAry[cacheAnsAryDone] = bOrder;
            ++cacheAnsAryDone;
            t = t.multiply(BigInteger.TEN);
        }
        return cacheAnsAry[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int ans=getAns(n);
            System.out.println(ans);
        }
    }
}
