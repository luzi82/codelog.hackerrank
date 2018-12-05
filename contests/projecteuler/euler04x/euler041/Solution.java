import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        int[] nAry = new int[t];
        for(int i=0;i<t;++i){
            nAry[i] = scanner.nextInt();
        }
        
        int nAryMax = nAry[0];
        for(int n:nAry){
            nAryMax = Math.max(nAryMax,n);
        }
        
        preparePandigitalList(nAryMax+1);
        Integer[] pandigitalAry = pandigitalList.toArray(new Integer[0]);
        
        for(int n:nAry){
            int i=Arrays.binarySearch(pandigitalAry, n);
            if(i<0){
                i=-i-2;
            }
            int ans = (i<0)?-1:pandigitalAry[i];
            System.out.println(ans);
        }
    }

    static int primeNextTest = 3;
    static HashSet<Integer> primeSet = new HashSet<Integer>();
    static LinkedList<Integer> primeList = new LinkedList<Integer>();
    static {primeSet.add(2);primeList.add(2);}
    static boolean isPrime(int v){
        if(v<=1)return false;
        if(primeSet.contains(v))return true;
        for(int p:primeList){
            if(v%p==0)return false;
            if(p*p>v){
                primeSet.add(v);
                return true;
            }
        }
        while(true){
            boolean pntIsPrime = true;
            if(!primeSet.contains(primeNextTest)){
                for(int p:primeList){
                    if(primeNextTest%p==0){
                        pntIsPrime = false;
                        break;
                    }
                    if(p*p>primeNextTest)break;
                }
                if(pntIsPrime){
                    primeSet.add(primeNextTest);
                }
            }
            if(pntIsPrime){
                primeList.add(primeNextTest);
            }
            int pnt=primeNextTest;
            ++primeNextTest;
            if(v%pnt==0)return false;
            if(pnt*pnt>v){
                primeSet.add(v);
                return true;
            }
        }
    }
    
    static LinkedList<Integer> pandigitalList = new LinkedList<>();
    static void preparePandigitalList(int max){
        //System.out.println(max);
        for(int d=1;d<=9;++d){
            TreeSet<Integer> available = new TreeSet<Integer>();
            for(int i=1;i<=d;++i){
                available.add(i);
            }
            boolean cont = dfs(0,available,max);
            if(!cont)break;
        }
    }
    
    static boolean dfs(int prefix,TreeSet<Integer> availableSet,int max){
        //System.out.println("dfs "+prefix);
        if(availableSet.size()==0){
            if(prefix>=max)return false;
            //System.out.println(prefix);
            if(isPrime(prefix)){
                pandigitalList.add(prefix);
            }
            return true;
        }
        Integer[] availableAry = availableSet.toArray(new Integer[0]);
        for(int i:availableAry){
            availableSet.remove(i);
            boolean cont=dfs(prefix*10+i,availableSet,max);
            if(!cont)return false;
            availableSet.add(i);
        }
        return true;
    }

}
