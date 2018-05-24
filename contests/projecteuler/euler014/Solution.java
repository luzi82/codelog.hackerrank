// timeout

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static Map<Integer,Integer> collatzLenMapValue = new HashMap<Integer,Integer>();

    public static int getCollatzLen(int v){
        LinkedList<Integer> collatzSeq = new LinkedList<Integer>();
        
        int vv = v;
        while(!collatzLenMapValue.containsKey(vv)){
            collatzSeq.add(vv);
            if(vv%2==0)vv/=2;
            else vv=3*vv+1;
        }
        
        int collatzLen = collatzLenMapValue.get(vv);
        ++collatzLen;
        
        while(!collatzSeq.isEmpty()){
            vv = collatzSeq.pollLast();
            collatzLenMapValue.put(vv,collatzLen);
            ++collatzLen;
        }
        
        return collatzLenMapValue.get(v);
    }
    
    static int[] maxCollatzLen = new int[5000000+10];
    static int[] maxCollatzVal = new int[5000000+10];
    static int maxCollatzLenDone = 1;

    public static int cal(int n){
        while(maxCollatzLenDone<=n){
            int cLen = getCollatzLen(maxCollatzLenDone);
            if(cLen>=maxCollatzLen[maxCollatzLenDone-1]){
                maxCollatzLen[maxCollatzLenDone] = cLen;
                maxCollatzVal[maxCollatzLenDone] = maxCollatzLenDone;
            }else{
                maxCollatzLen[maxCollatzLenDone] = maxCollatzLen[maxCollatzLenDone-1];
                maxCollatzVal[maxCollatzLenDone] = maxCollatzVal[maxCollatzLenDone-1];
            }
            ++maxCollatzLenDone;
        }
        
        return maxCollatzVal[n];
    }

    public static void main(String[] args) {
        collatzLenMapValue.put(1,1);
        maxCollatzLen[0]=0;
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;++i){
            int n = in.nextInt();
            int ret = cal(n);
            System.out.println(ret);
        }
    }

}
