import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        if(b==5){
            long i=1;
            while(true){
                long p = i*(3*i-1)/2;
                if(p>=N)break;
                if(isQ(1,1,-2*p))System.out.println(p);
                ++i;
            }
        }
        if(b==6){
            long i=1;
            while(true){
                long h = i*(2*i-1);
                if(h>=N)break;
                if(isQ(3,-1,-2*h))System.out.println(h);
                ++i;
            }
        }
    }
    
    public static boolean isQ(long a,long b,long c){
        double[] rootAry = getRootAry(a,b,c);
        for(double root:rootAry){
            if(root<=0)continue;
            if(Math.floor(root)!=root)continue;
            //System.out.println(root);
            return true;
        }
        return false;
    }

    public static double[] getRootAry(long a,long b,long c){
        long b4ac = b*b - 4*a*c;
        if(b4ac<0)return new double[0];
        double rb4ac = Math.sqrt(b4ac);
        //System.out.println(String.format("%d %d",b4ac,rb4ac));
        if(rb4ac==0){
            return new double[]{-b/(2*a)};
        }
        return new double[]{(-b-rb4ac)/(2*a),(-b+rb4ac)/(2*a)};
    }

}
