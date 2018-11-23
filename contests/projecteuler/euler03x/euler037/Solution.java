import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] ansV = new int[1];
        search(ansV, 0, 1, n);
        System.out.println(ansV[0]);
    }
    
    public static void search(int[] ansV, int right, int ten, int n){
        if(right>n)return;
        if(right>0){
            if(!isPrime(right))return;
            boolean isLeftPrime = true;
            for(int r=right/10;r>0;r/=10){
                if(!isPrime(r)){
                    isLeftPrime=false;
                    break;
                }
            }
            if(right>=10&&isLeftPrime){
                ansV[0] += right;
            }
            //System.out.println("right "+right);
        }
        
        for(int i=1;i<10;++i){
            search(ansV,right+i*ten,ten*10,n);
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
