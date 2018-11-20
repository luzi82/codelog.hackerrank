import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static int[] FACTORIAL_ARY=new int[10];
    static{
        FACTORIAL_ARY[0]=1;
        for(int i=1;i<10;++i){
            FACTORIAL_ARY[i]=FACTORIAL_ARY[i-1]*i;
        }
    }

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        long curiousSum = 0;
        
        for(int i=10;i<n;++i){
            if(isCurious(i)){
                curiousSum+=i;
            }
        }
        
        System.out.println(curiousSum);
    }
    
    public static boolean isCurious(int v){
        int factorialSum = 0;
        int vv = v;
        while(vv>0){
            int digi = vv%10;
            factorialSum+=FACTORIAL_ARY[digi];
            vv/=10;
        }
        return factorialSum%v==0;
    }
    
}
