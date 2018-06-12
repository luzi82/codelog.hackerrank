import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Test{

    public static void testPrimeFactorIndexList(int v){
        System.out.println("testPrimeFactorIndexList "+v);
        List<int[]> ll = Solution.getPrimeFactorIndexList(v);
        for(int[] i:ll){
            System.out.format("%d %d\n",i[0],i[1]);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.calProperDivisorSum(220));
        System.out.println(Solution.calProperDivisorSum(284));
        System.out.println(Solution.pow(2,3));
        testPrimeFactorIndexList(220);
        System.out.println(Solution.cal(100000));
        System.out.println(Solution.cal(220));
        System.out.println(Solution.cal(221));
        for(int i=1;i<=100000;++i){
            if(Solution.isAmicable(i)){
                System.out.println("isAmicable "+i);
            }
        }
        testPrimeFactorIndexList(65537);
        System.out.println(Solution.calProperDivisorSum(65537));
        System.out.println(Solution.calProperDivisorSum(29585));
        System.out.println(Solution.isAmicable(65537));
    }

}