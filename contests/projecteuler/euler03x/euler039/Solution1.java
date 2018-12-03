import java.io.*;
import java.util.*;
import java.math.*;

// brute force, slow

public class Solution1 {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for(int i=0;i<t;++i){
            int n = scanner.nextInt();
            int v = calc(n);
            System.out.println(v);
        }
    }
    
    static int[] ans= new int[100010];
    static int[] count= new int[100010];
    static int ansDone = 13;
    static {
        ans[12]=12;
        count[12]=1;
    }
    
    static int calc(int n){
        for(;ansDone<=n;++ansDone){
            int ccount = ccalc(ansDone);
            if(ccount>count[ansDone-1]){
                ans[ansDone]=ansDone;
                count[ansDone]=ccount;
            }else{
                ans[ansDone]=ans[ansDone-1];
                count[ansDone]=count[ansDone-1];
            }
        }
        return ans[n];
    }
    
    static int ccalc(int v){
        int ret = 0;
        int min = v/4;
        int max = v/2;
        for(int i=min;i<=max;++i){
            if(binSearch(i,v)){
                ++ret;
            }
        }
        return ret;
    }
    
    static boolean binSearch(int b,int sum){
        int b2=b*b;
        int min = 0;
        int max = b;
        while(true){
            int a = (min+max)/2;
            if(a==min)return false;
            if(a==max)return false;
            int c = sum-b-a;
            if(c<b){
                max = a;
                continue;
            }
            int diff = c*c - b2 - a*a;
            if(diff==0)return true;
            if(diff>0){
                min = a;
            }else{
                max = a;
            }
        }
    }

}
