import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    public static BigInteger TWO = BigInteger.valueOf(2);
    public static BigInteger[] twoPowAryIdx = new BigInteger[10010];
    public static int twoPowAryIdxDone;
    
    public static int cal(int n){
        while(twoPowAryIdxDone<=n){
            twoPowAryIdx[twoPowAryIdxDone]=twoPowAryIdx[twoPowAryIdxDone-1].multiply(TWO);
            ++twoPowAryIdxDone;
        }
        
        String str = twoPowAryIdx[n].toString();
        int ret = 0;
        for(char c:str.toCharArray()){
            ret += (int)(c-'0');
        }
        
        return ret;
    }

    public static void main(String[] args) {
        twoPowAryIdx[0] = BigInteger.ONE;
        twoPowAryIdxDone=1;
        
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int ans=cal(n);
            System.out.println(ans);
        }
    }
}
