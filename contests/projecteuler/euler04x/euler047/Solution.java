import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

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
        HashSet<Integer> goodIntSet = new HashSet<Integer>();
        buildGoodIntSet(goodIntSet,N,K,new int[K],0);
        
        LinkedList<Integer> retList = new LinkedList<Integer>();
        int consecutiveGoodCount=0;
        for(int i=2;i<N+K;++i){
            if(!goodIntSet.contains(i)){
                consecutiveGoodCount=0;
                continue;
            }
            ++consecutiveGoodCount;
            if(consecutiveGoodCount>=K){
                retList.add(i+1-K);
            }
        }
        
        return retList;
    }
    
    public static boolean buildGoodIntSet(HashSet<Integer> goodIntSet,int N,int K,int[] primeIdxList,int done){
        if(done==K){
            return buildGoodIntSet(goodIntSet,primeIdxList,N+K);
        }
        int primeIdx=(done==0)?0:(primeIdxList[done-1]+1);
        primeIdxList[done]=primeIdx++;
        boolean ret = buildGoodIntSet(goodIntSet,N,K,primeIdxList,done+1);
        if(!ret)return false;
        while(true){
            primeIdxList[done]=primeIdx++;
            ret = buildGoodIntSet(goodIntSet,N,K,primeIdxList,done+1);
            if(!ret)return true;
        }
    }
    
    public static boolean buildGoodIntSet(HashSet<Integer> goodIntSet,int[] primeIdxList,int max){
        int[] primeList=new int[primeIdxList.length];
        for(int i=0;i<primeList.length;++i){
            primeList[i]=getPrime(primeIdxList[i]);
        }
        int min=1;
        for(int prime:primeList){
            min*=prime;
        }
        if(min>=max)return false;
        buildGoodIntSet(goodIntSet,primeList,1,0,max);
        return true;
    }

    public static boolean buildGoodIntSet(HashSet<Integer> goodIntSet,int[] primeList,long v,int done,long max){
        if(v>=max)return false;
        if(done==primeList.length){
            goodIntSet.add((int)v);return true;
        }
        int prime = primeList[done];
        v *= prime;
        boolean ret;
        ret = buildGoodIntSet(goodIntSet,primeList,v,done+1,max);
        if(!ret)return false;
        while(true){
            v *= prime;
            ret = buildGoodIntSet(goodIntSet,primeList,v,done+1,max);
            if(!ret)return true;
        }
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