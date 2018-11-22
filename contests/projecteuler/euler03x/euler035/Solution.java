import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int nLog10 = (int)Math.floor(Math.log(n)/Math.log(10));
        int nPow10 = (int)Math.pow(10,nLog10);
        preparePrime(nPow10*10-1);
        Set<Integer> primeSet = new HashSet<Integer>(primeV);
        
        int ans = 0;
        Set<Integer> numDone = new HashSet<Integer>();
        for(int i:primeV){
            if(i>=n)break;
            if(numDone.contains(i))continue;
            int ii=i;
            int iLog10 = (int)Math.floor(Math.log(i)/Math.log(10));
            int iPow10 = (int)Math.pow(10,iLog10);
            boolean isCircularPrime = true;
            Collection<Integer> circularNum = new LinkedList<Integer>();
            circularNum.add(i);
            while(true){
                ii += (ii%10)*10*iPow10;
                ii /= 10;
                if(ii==i)break;
                if(ii<n){
                    numDone.add(ii);
                    circularNum.add(ii);
                }
                if(!primeSet.contains(ii)){
                    isCircularPrime = false;
                    break;
                }
            }
            if(isCircularPrime){
                for(int j:circularNum){
                    ans+=j;
                }
            }
            circularNum.clear();
        }
        
        System.out.println(ans);
    }

    static Vector<Integer> primeV=new Vector<Integer>();

    static void preparePrime(int max){
        if(primeV.size()==0){
            primeV.add(2);
        }
        int p=3;
        while(p<max){
            boolean isPrime=true;
            for(int pp:primeV){
                if(p%pp==0){isPrime=false;break;}
                if(pp*pp>p){break;}
            }
            if(isPrime){
                primeV.add(p);
            }
            p+=2;
        }
    }

}
