import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            
            int maxProduct = 0;
            int product = 1;
            int[] lastNumAry = new int[k];
            for(int i=0;i<k;++i){
                lastNumAry[i]=1;
            }
            int zeroCount = k;
            boolean[] zeroAry = new boolean[k];
            for(int i=0;i<k;++i){
                zeroAry[i]=true;
            }
            int ptrIdx=0;
            
            char[] numCharAry = num.toCharArray();
            for(int i=0;i<numCharAry.length;++i){
                product/=lastNumAry[ptrIdx];
                zeroCount-=(zeroAry[ptrIdx])?1:0;
                
                int numI = numCharAry[i]-'0';
                if(numI==0){
                    lastNumAry[ptrIdx]=1;
                    zeroAry[ptrIdx]=true;
                    ++zeroCount;
                }else{
                    lastNumAry[ptrIdx]=numI;
                    zeroAry[ptrIdx]=false;
                    product*=numI;
                }
                
                if(zeroCount==0){
                    maxProduct=Math.max(maxProduct,product);
                }
                
                ++ptrIdx;
                ptrIdx%=k;
            }
            
            System.out.println(maxProduct);
        }
    }
}
