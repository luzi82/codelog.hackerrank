import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // find max index
        int idxMax = (int)Math.ceil(Math.log(n)/Math.log(2));
        //System.err.println(idxMax);
        
        // create idxToCnt
        Map<Integer,Integer> idxToCnt = new HashMap<Integer,Integer>();
        Set<Integer> powerDone = new HashSet<Integer>();
        for(int idx=1;idx<=idxMax;++idx){
            //System.err.println(idx);
            for(int i=2;i<=n;++i){
                int power = i*idx;
                if(powerDone.contains(power))continue;
                powerDone.add(power);
            }
            idxToCnt.put(idx,powerDone.size());
        }
        
        // cal distinct powers cnt
        long distinctPowerCnt = 0;
        Set<Long> baseDone = new HashSet<Long>();
        for(long base=2;base<=n;++base){
            //System.err.println(base);
            if(baseDone.contains(base))continue;
            int idx=1;
            long basee=base;
            while(true){
                baseDone.add(basee);
                basee*=base;
                if(basee>n)break;
                idx+=1;
            }
            //System.err.println(""+base+" "+idx+" "+idxToCnt.get(idx));
            distinctPowerCnt += idxToCnt.get(idx);
        }
        
        // print ans
        System.out.println(distinctPowerCnt);
    }
}
