import java.io.*;
import java.util.*;

public class Solution {

    static int calCycleLen(int n){
        int remain = 1;
        Integer[] stepAryRemain = new Integer[n+10];
        
        int step = 0;
        stepAryRemain[remain] = step;
        ++step;
        
        while(true){
            remain*=10;
            remain%=n;
            if(remain==0)return 0;
            if(stepAryRemain[remain]!=null){
                return step - stepAryRemain[remain];
            }
            stepAryRemain[remain] = step;
            ++step;
        }
    }

    static int[] cacheLenAry = new int[10010];
    static int[] cacheAnsAry = new int[10010];
    static int cacheAryDone;
    static {
        cacheLenAry[0] = 0;
        cacheAnsAry[0] = 0;
        cacheLenAry[1] = 0;
        cacheAnsAry[1] = 1;
        cacheAryDone = 2;
    }

    static int getAns(int n){
        --n;
        while(cacheAryDone<=n){
            int cycleLen = calCycleLen(cacheAryDone);
            if(cycleLen>cacheLenAry[cacheAryDone-1]){
                cacheLenAry[cacheAryDone] = cycleLen;
                cacheAnsAry[cacheAryDone] = cacheAryDone;
            }else{
                cacheLenAry[cacheAryDone] = cacheLenAry[cacheAryDone-1];
                cacheAnsAry[cacheAryDone] = cacheAnsAry[cacheAryDone-1];
            }
            ++cacheAryDone;
        }
        return cacheAnsAry[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int ans = getAns(n);
            System.out.println(ans);
        }
    }
}
