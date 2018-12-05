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
        
        preparePrime((int)(Math.sqrt(nAryMax)+1));
        preparePandigitalList(nAryMax+1);
        
        int[] pandigitalAry = new int[pandigitalList.size()];
        int idx=0;
        for(Integer pandigital:pandigitalList){
            pandigitalAry[idx]=pandigital;
            ++idx;
        }
        
        for(int n:nAry){
            int i=Array.binarySearch(pandigitalAry, n);
            if(i<0){
                i=-i-2;
            }
            int ans = (i<0)?-1:pandigitalAry[i];
            System.out.println(ans);
        }
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
    
    static LinkedList<Integer> pandigitalList = new LinkedList<>;
    static void preparePandigitalList(int max){
        for(int d=1;d<=9;++d){
            boolean[] used = new boolean[d+1];
            StringBuffer sb = new StringBuffer();
            boolean big = dfs(sb,used);
            if(big)break;
        }
    }
    
    static boolean (StringBuffer sb,boolean used){
        if(sb.length()>used.length){
            
        }
    }

}
