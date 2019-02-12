import java.io.*;
import java.util.*;
import java.math.*;

// slower than Solution.java, not tested in hackerRank

public class SolutionX {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        // cal
        LinkedList<Integer> ansList = cal(N,K);
        
        // output
        for(int ans:ansList){
            System.out.println(ans);
        }
    }
    
    public static LinkedList<Integer> cal(int N,int K){
        LinkedList<Integer> retList = new LinkedList<Integer>();
        int consecutiveCount=0;
        for(int i=2;i<N+K;++i){
            boolean good = isGood(i,K);
            //System.err.println(String.format("%d %d",i,good?1:0));
            if(!good){
                consecutiveCount=0;
                continue;
            }
            ++consecutiveCount;
            if(consecutiveCount>=K){
                retList.add(i+1-K);
            }
        }
        return retList;
    }
    
    public static boolean isGood(int v,int K){
        int primeCount = 0;
        int i=0;
        while(v!=1){
            //System.err.println(v);
            int p = getPrime(i);
            if(v%p==0){
                ++primeCount;
                while(v%p==0){
                    v=v/p;
                }
                if(v==1)break;
                if(primeCount==K){
                    return false;
                }
            }
            if(p*p>v){
                ++primeCount;
                break;
            }
            ++i;
        }
        return (primeCount==K);
    }

    static Vector<Integer> primeV=new Vector<Integer>();
    static int getPrime(int idx){
        if(primeV.size()==0){
            primeV.add(2);
            primeV.add(3);
        }
        while(idx>=primeV.size()){
            int p=primeV.lastElement();
            while(true){
                p+=2;
                boolean isPrime=true;
                for(int pp:primeV){
                    if(p%pp==0){isPrime=false;break;}
                    if(pp*pp>p){break;}
                }
                if(isPrime)break;
            }
            primeV.add(p);
        }
        return primeV.get(idx);
    }
}