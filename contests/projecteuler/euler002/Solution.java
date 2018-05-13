import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        SortedMap<Long, Long> sumAMapA = new TreeMap<Long,Long>();
        sumAMapA.put(2L,2L);
        
        long lastA=2;
        long lastB=3;
        long lastSum=2;
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            while(lastA<n){
                long a = lastA+2*lastB;
                long b = 2*lastA+3*lastB;
                long sum = lastSum+a;
                sumAMapA.put(a,sum);
                lastA=a;
                lastB=b;
                lastSum=sum;
            }
            long lastF = sumAMapA.headMap(n+1).lastKey();
            long ans = sumAMapA.get(lastF);
            System.out.println(ans);
        }
    }
}
