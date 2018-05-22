import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {
    public static void assertTrue(boolean v){
        if(!v)throw new Error();
    }
    public static void main(String[] args) {
        assertTrue(Solution.getPrime(0)==2);
        assertTrue(Solution.getPrime(1)==3);
        assertTrue(Solution.getPrime(2)==5);
        assertTrue(Solution.getPrime(3)==7);
        assertTrue(Solution.getPrime(4)==11);

        assertTrue(Solution.getFactorCount(1)==1);
        assertTrue(Solution.getFactorCount(2)==2);
        assertTrue(Solution.getFactorCount(3)==2);
        assertTrue(Solution.getFactorCount(4)==3);
        assertTrue(Solution.getFactorCount(5)==2);
        assertTrue(Solution.getFactorCount(6)==4);
        assertTrue(Solution.getFactorCount(7)==2);
        assertTrue(Solution.getFactorCount(8)==4);
        assertTrue(Solution.getFactorCount(9)==3);
        assertTrue(Solution.getFactorCount(10)==4);
        assertTrue(Solution.getFactorCount(27)==4);
        assertTrue(Solution.getFactorCount(81)==5);
        assertTrue(Solution.getFactorCount(100)==9);

        for(int i=1;i<100;++i){
            long a=Solution.getFactorCount((long)i);
            long b=Solution.getFactorCount((long)i+1);
            long c=Solution.getFactorCount((long)i*(i+1));
            assert(a*b==c);
        }
        
        assertTrue(Solution.cal(1)==3);
        assertTrue(Solution.cal(2)==6);
        assertTrue(Solution.cal(3)==6);
        assertTrue(Solution.cal(4)==28);

        System.out.println("PASS");
    }
}
