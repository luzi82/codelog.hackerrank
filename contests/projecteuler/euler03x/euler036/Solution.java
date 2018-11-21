import java.io.*;
import java.util.*;
import java.math.*;

// faster

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int nLen = Integer.toString(n).length();
        int testMax = (int)Math.pow(10,(nLen+1)/2);

        long ans=0;
        
        for(int i=0;i<testMax;++i){
            String v=Integer.toString(i);
            String vv;
            String rv = rev(v);
            vv = v+rv;
            int ii = Integer.parseInt(vv);
            if(ii<n){
                vv = Integer.toString(ii,k);
                if(isPalindromic(vv)){
                    ans+=ii;
                }
            }
            vv = v+rv.substring(1);
            ii = Integer.parseInt(vv);
            if(ii<n){
                vv = Integer.toString(ii,k);
                if(isPalindromic(vv)){
                    ans+=ii;
                }
            }
        }
        
        System.out.println(ans);
    }
    
    public static String rev(String v){
        char[] cv=v.toCharArray();
        char[] cv2 = new char[cv.length];
        for(int i=0;i<cv.length;++i){
            cv2[i]=cv[cv.length-1-i];
        }
        return new String(cv2);
    }
    
    public static boolean isPalindromic(String v){
        char[] cv=v.toCharArray();
        for(int i=0;i<cv.length/2;++i){
            if(cv[i]!=cv[cv.length-1-i])return false;
        }
        return true;
    }

}
