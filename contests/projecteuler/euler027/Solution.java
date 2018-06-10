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
                isPrimeMapValue.put(p,false); // shortcut
                ++p;
            }
            isPrimeMapValue.put(p,true); // shortcut
            primeV.add(p);
        }
        return primeV.get(idx);
    }
    
    static boolean calIsPrime(int v){
        if(v<=0)return false;
        int idx=0;
        while(true){
            int prime = getPrime(idx);
            if(v==prime)return true;
            if(v%prime==0)return false;
            if(prime*prime>v)return true;
            ++idx;
        }
    }
    
    static Map<Integer,Boolean> isPrimeMapValue=new HashMap<Integer,Boolean>();
    static boolean isPrime(int v){
        if(v<=0)return false;
        if(!isPrimeMapValue.containsKey(v)){
            isPrimeMapValue.put(v,calIsPrime(v));
        }
        return isPrimeMapValue.get(v);
    }

    static int[] calAns(int n){
        int[] ans = null;
        int maxLen=-1;
        for(int a=-n;a<=n;++a)for(int b=-n;b<=n;++b){
            int x=0;
            while(true){
                int xx=x*x+a*x+b;
                if(!isPrime(xx))break;
                ++x;
            }
            if(x>maxLen){
                ans=new int[]{a,b};
                maxLen = x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = calAns(n);
        System.out.format("%d %d\n",ans[0],ans[1]);
    }
}
