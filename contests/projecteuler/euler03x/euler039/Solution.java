import java.io.*;
import java.util.*;
import java.math.*;

// a = mm - nn
// b = 2mn
// c = mm + nn

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] nAry = new int[t];

        for(int i=0;i<t;++i){
            nAry[i] = scanner.nextInt();
        }
        
        int nAryMax = 0;
        for(int i=0;i<t;++i){
            nAryMax = Math.max(nAryMax,nAry[i]);
        }
        
        int[] countAry = new int[nAryMax+1];
        
        int n=1;
        while(true){
            int m=n+1;
            int s = 2*m*m + 2*m*n;
            if(s>nAryMax)break;
            while(true){
                s = 2*m*m + 2*m*n;
                if(s>nAryMax)break;
                int a = m*m - n*n;
                int b = 2*m*n;
                if(gcd(a,b)==1){
                    for(int i=1;i*s<=nAryMax;++i){
                        countAry[i*s]++;
                    }
                }
                ++m;
            }
            ++n;
        }

        int[] ansAry = new int[nAryMax+1];
        int lastCount = 0;
        int lastAns = 0;
        for(int i=1;i<=nAryMax;++i){
            if(countAry[i]>lastCount){
                lastCount=countAry[i];
                lastAns=i;
            }
            ansAry[i]=lastAns;
        }
        
        for(int i=0;i<t;++i){
            System.out.println(ansAry[nAry[i]]);
        }
    }
    
    static int gcd(int b,int c){
        while(true){
            int a=c%b;
            if(a==0)return b;
            c=b;b=a;
        }
    }
    
}
