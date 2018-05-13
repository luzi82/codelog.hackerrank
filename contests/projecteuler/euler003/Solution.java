import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        List<Long> primeList = new LinkedList<Long>();
        primeList.add(2L);
        long maxPrimeFound = 2;
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long ret = -1;
            
            for(long prime:primeList){
                while(n%prime==0){
                    n/=prime;
                    ret = Math.max(ret,prime);
                }
                if(prime*prime>n){
                    ret = Math.max(n,ret);
                    n = 1;
                    break;
                }
            }
            
            while(n>1){
                while(true){
                    boolean isPrime=true;
                    ++maxPrimeFound;
                    for(long prime:primeList){
                        if(prime*prime>maxPrimeFound)break;
                        if(maxPrimeFound%prime!=0)continue;
                        isPrime = false; break;
                    }
                    if(isPrime)break;
                }
                primeList.add(maxPrimeFound);
                while(n%maxPrimeFound==0){
                    n/=maxPrimeFound;
                    ret = Math.max(ret,maxPrimeFound);
                }
                if(maxPrimeFound*maxPrimeFound>n){
                    ret = Math.max(n,ret);
                    n = 1;
                    break;
                }
            }
            
            System.out.println(ret);
        }
    }
}
