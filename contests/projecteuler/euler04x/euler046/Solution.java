import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for(int ti=0;ti<T;++ti){
            long N = scanner.nextLong();
            int ans = 0;
            long i=1;
            while(true){
                long ii=2*i*i;
                if(ii>=N)break;
                int diff = (int)(N-ii);
                if(isPrime(diff))++ans;
                ++i;
            }
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

}
