import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long gcd(long a,long b){
        if(a>b){return gcd(b,a);}
        while(true){
            if(b%a==0)return a;
            long t=b%a;
            b=a;a=t;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long ret=1;
            for(int i=n;i>=1;--i){
                long ggcd=gcd(ret,i);
                ret/=ggcd;
                ret*=i;
            }
            System.out.println(ret);
        }
    }
}
