import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static Vector<Integer> primeV=new Vector<Integer>();
    static int getPrime(int idx){
        if(primeV.size()==0){
            primeV.add(2);
        }
        while(idx>=primeV.size()){
            int p=primeV.lastElement();
            ++p;
            while(true){
                boolean isPrime=true;
                for(int pp:primeV){
                    if(p%pp==0){isPrime=false;break;}
                    if(pp*pp>p){break;}
                }
                if(isPrime)break;
                ++p;
            }
            primeV.add(p);
        }
        return primeV.get(idx);
    }
    
    static Map<Long,Long> factorCountMapVal=new HashMap<Long,Long>();
    static long getFactorCount(long v){
        if(v==1)return 1;
        if(!factorCountMapVal.containsKey(v)){
            long vv=v;
            long factorCount=1;
            int primeIdx=0;
            while(true){
                if(vv==1)break;
                int prime=getPrime(primeIdx);
                int multi = 1;
                while(vv%prime==0){
                    vv/=prime;
                    ++multi;
                }
                factorCount*=multi;
                if(vv==1)break;
                if(prime*prime>vv){
                    factorCount*=2;
                    break;
                }
                ++primeIdx;
            }
            factorCountMapVal.put(v,factorCount);
        }
        return factorCountMapVal.get(v);
    }

    public static long cal(int n){
        long a=1;
        while(true){
            long aa=a;
            long bb=a+1;
            if(aa%2==0){aa/=2;}
            else{bb/=2;}
            long factorCount=getFactorCount(aa)*getFactorCount(bb);
            if(factorCount>n){return aa*bb;}
            ++a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;++i){
            int n = in.nextInt();
            long v=cal(n);
            System.out.println(v);
        }
    }

}
