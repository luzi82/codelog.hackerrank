import java.io.*;
import java.util.*;
import java.math.*;

// obvious, pass

public class Solution0 {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        long ans=0;
        
        for(int i=0;i<n;++i){
            String v;
            v = Integer.toString(i);
            if(!isPalindromic(v))continue;
            v = Integer.toString(i,k);
            if(!isPalindromic(v))continue;
            ans += i;
        }
        
        System.out.println(ans);
    }
    
    public static boolean isPalindromic(String v){
        char[] cv=v.toCharArray();
        for(int i=0;i<cv.length/2;++i){
            if(cv[i]!=cv[cv.length-1-i])return false;
        }
        return true;
    }

}
