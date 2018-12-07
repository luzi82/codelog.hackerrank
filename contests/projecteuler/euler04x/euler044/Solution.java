import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        
        TreeSet<Long> ansSet = new TreeSet<>();
        for(long ni=k+1;ni<n;++ni){
            long pni = P(ni);
            long pnik = P(ni-k);
            long p0 = pni-pnik;
            if(isP(p0)){ansSet.add(pni);}
            long p1 = pni+pnik;
            if(isP(p1)){ansSet.add(pni);}
        }
        
        for(Long ans:ansSet){
            System.out.println(ans);
        }
    }

    public static long P(long n){
        return n*(3*n-1)/2;
    }
    
    public static boolean isP(long v){
        long tmp=v;
        tmp=1+24*tmp;
        long tmpD = (long)Math.floor(Math.sqrt((double)tmp));
        if(tmpD*tmpD!=tmp)return false;
        tmp = (long)tmpD;
        long tmp0 = 1+tmp;
        if((tmp0>0)&&(tmp0%6==0))return true;
        tmp0 = 1-tmp;
        if((tmp0>0)&&(tmp0%6==0))return true;
        return false;
    }

}
