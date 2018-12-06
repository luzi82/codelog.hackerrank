import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for(int i=0;i<t;++i){
            long n = scanner.nextLong();
            long ans = sqrt(n*2);
            //System.out.println(ans);
            if(ans*(ans+1)/2!=n){
                ans = -1;
            }
            System.out.println(ans);
        }
    }
    
    public static long sqrt(long n){
        if(n==0)return 0;
        long min=0;
        long max=2147483648L; // 2^31
        while(true){
            long mid = (min+max)/2;
            if(mid==min)return mid;
            long mid2 = mid*mid;
            if(mid2==n)return mid;
            if(mid2<n){min=mid;}else{max=mid;}
        }
    }
    
}
