import java.io.*;
import java.util.*;

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

    static List<int[]> getPrimeFactorIndexList(int v){
        LinkedList<int[]> ans = new LinkedList<int[]>();

        int primeIdx=0;
        while(true){
            if(v==1)break;
            int prime=getPrime(primeIdx);
            int index = 0;
            while(v%prime==0){
                v/=prime;
                ++index;
            }
            if(index>0){
                ans.add(new int[]{prime,index});
            }
            if(prime*prime>v){
                if(v!=1){
                    ans.add(new int[]{v,1});
                }
                break;
            }
            ++primeIdx;
        }
        
        return ans;
    }
    
    static long pow(int a,int b){
        long ans=1;
        for(int i=0;i<b;++i){
            ans*=a;
        }
        return ans;
    }
    
    static int calProperDivisorSum(int v){
        if(v==0)return 0;
        if(v==1)return 0;
        List<int[]> pfiList = getPrimeFactorIndexList(v);
        long ans = 1;
        for(int[] pfi:pfiList){
            ans *= (pow(pfi[0],pfi[1]+1)-1)/(pfi[0]-1);
        }
        ans -= v;
        return (int)ans;
    }

    static boolean calAbundant(int v){
        int vv = calProperDivisorSum(v);
        return vv > v;
    }
    
    static Boolean[] cacheAbundanAry = new Boolean[100010];

    static boolean isAbundant(int v){
        if(cacheAbundanAry[v] == null){
            cacheAbundanAry[v]=calAbundant(v);
        }
        return cacheAbundanAry[v];
    }
    
    static boolean cal(int n){
        for(int i=1;i<n;++i){
            int ii = n-i;
            if(ii<i)break;
            if(!isAbundant(i))continue;
            if(!isAbundant(ii))continue;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            boolean ans = cal(n);
            System.out.println(ans?"YES":"NO");
        }
    }
}
