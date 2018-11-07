import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    final static long BIG = 1000000000+7;
    final static int[] COIN_VALUE_ARY = {1,2,5,10,20,50,100,200};

    public static void main(String[] args) {
        // get all input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        Integer[] nAry = new Integer[t];
        for(int i=0;i<t;++i){
            nAry[i] = scanner.nextInt();
        }
        int nMax = Collections.max(Arrays.asList(nAry));
        
        // cal answer of all
        long[][] wayCountAryAry = new long[nMax+1][COIN_VALUE_ARY.length+1];
        for(int i=0;i<wayCountAryAry[0].length;++i){
          wayCountAryAry[0][i] = 1;
        }
        
        for(int i=1;i<=nMax;++i){
            wayCountAryAry[i][0] = 0;
            for(int j=0;j<COIN_VALUE_ARY.length;++j){
                int wayCount = 0;
                int v = i-COIN_VALUE_ARY[j];
                if(v>=0){
                    wayCount += wayCountAryAry[v][j+1];
                }
                wayCount += wayCountAryAry[i][j];
                wayCount %= BIG;
                wayCountAryAry[i][j+1] = wayCount;
            }
        }
        
        // print ans
        for(int i=0;i<t;++i){
            System.out.println(wayCountAryAry[nAry[i]][COIN_VALUE_ARY.length]);
        }
    }
}
