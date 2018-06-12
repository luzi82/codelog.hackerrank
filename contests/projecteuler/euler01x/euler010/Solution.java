import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        long[] primeAry=new long[1000000/3];
        long[] primeSumAry=new long[1000000/3];
        
        primeAry[0]=2;
        primeSumAry[0]=2;
        int primeDone = 1;
        
        int nextPrimeTest = 3;
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            while(nextPrimeTest<=n){
                boolean good=true;
                for(int i=0;i<primeDone;++i){
                    long prime=primeAry[i];
                    if(nextPrimeTest%prime==0){good=false;break;}
                    if(prime*prime>nextPrimeTest)break;
                }
                if(good){
                    primeAry[primeDone]=nextPrimeTest;
                    primeSumAry[primeDone]=primeSumAry[primeDone-1]+nextPrimeTest;
                    ++primeDone;
                }
                ++nextPrimeTest;
            }
            int primeIdx = Arrays.binarySearch(primeAry,0,primeDone,n);
            if(primeIdx<0){
                primeIdx=0-primeIdx-2;
            }
            long ret = (primeIdx>=0)?primeSumAry[primeIdx]:0;
            System.out.println(ret);
        }
        
    }
}
