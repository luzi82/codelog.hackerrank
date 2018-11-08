import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        Set<Integer> productSet = new HashSet<>();

        int c = n/2;
        int nc = n-c;

        boolean[] digitDoneStateAry = new boolean[n];
        int[] permutAry = new int[nc];
        search(digitDoneStateAry, permutAry, 0, nc, n, productSet);

        long ans = 0;
        for(int i:productSet){
            ans += i;
        }
        
        System.out.println(ans);
    }

    public static void search(boolean[] digitDoneStateAry, int[] permutAry, int done, int nc, int n, Set<Integer> productSet){
        if(done==nc){
            check(digitDoneStateAry, permutAry, nc, n, productSet);
            return;
        }
        for(int i=0;i<n;++i){
            if(digitDoneStateAry[i])continue;
            digitDoneStateAry[i] = true;
            permutAry[done] = i+1;
            search(digitDoneStateAry, permutAry, done+1, nc, n, productSet);
            digitDoneStateAry[i] = false;
        }
    }

    public static void check(boolean[] digitDoneStateAry, int[] permutAry, int nc, int n, Set<Integer> productSet){
        int c = n-nc;
        int aMax = (nc)/2;
        for(int a=1;a<=aMax;++a){
            int b=nc-a;
            checkk(digitDoneStateAry, permutAry, a, b, c, n, productSet);
        }
    }
    
    public static void checkk(boolean[] digitDoneStateAry, int[] permutAry, int a, int b, int c, int n, Set<Integer> productSet){
        int aa = num(permutAry,0,a);
        int bb = num(permutAry,a,a+b);
        int cc = aa*bb;
        String ccStr = Integer.toString(cc);
        if(ccStr.length()!=c)return;
        char[] ccCharAry = ccStr.toCharArray();
        for(int i=0;i<ccCharAry.length;++i){
            char ccChar=ccCharAry[i];
            if(ccChar=='0')return; // check zero exist
            if(ccChar>('0'+n))return; // check > n exist
            if(digitDoneStateAry[ccChar-'1'])return; // digitDoneStateAry
        } 
        // check dup char
        Arrays.sort(ccCharAry);
        for(int i=0;i<ccCharAry.length-1;++i){
            if(ccCharAry[i]==ccCharAry[i+1])return;
        }
        //System.out.println(""+aa+" "+bb+" "+cc);
        productSet.add(cc);
    }
    
    public static int num(int[] permutAry, int x, int y){
        int ret=0;
        for(int i=x;i<y;++i){
            ret*=10;
            ret+=permutAry[i];
        }
        return ret;
    }

}
