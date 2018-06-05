import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    static BigInteger[] calAnsAry=new BigInteger[1010];
    static int calAnsAryDone;

    public static int cal(int n){
        while (calAnsAryDone<=n){
            calAnsAry[calAnsAryDone] = calAnsAry[calAnsAryDone-1].multiply(BigInteger.valueOf(calAnsAryDone));
            ++calAnsAryDone;
        }
        BigInteger factBi = calAnsAry[n];
        String factStr = factBi.toString();
        int ans = 0;
        for(char factC : factStr.toCharArray()){
            ans += factC-'0';
        }
        return ans;
    }

    public static void main(String[] args) {
        calAnsAry[0]=BigInteger.valueOf(1);
        calAnsAry[1]=BigInteger.valueOf(1);
        calAnsAryDone=2;
    
        Scanner scanner = new Scanner(System.in);
        
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int ans = cal(n);
            System.out.println(ans);
        }
    }
}
