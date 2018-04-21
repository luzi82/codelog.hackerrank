import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Cell{
        public Set<Integer> oneNumSet=new HashSet<Integer>();
        public Set<Integer> badNumSet=new HashSet<Integer>();
    }

    static int cal(int n,int m,int[] sAry){
        Cell[] cellAry=new Cell[m+1];
        for(int i=0;i<=m;++i){cellAry[i]=new Cell();}
        
        cellAry[0].oneNumSet.add(0);
        
        for(int i=0;i<n;++i){
            int m0=Math.max(0,i-n+m);
            int m1=Math.min(m-1,i);
            //System.out.format("CDFBRBTA i=%d, m0=%d m1=%d\n",i,m0,m1);
            for(int mm=m1;mm>=m0;--mm){
                Cell c0=cellAry[mm];
                Cell c1=cellAry[mm+1];
                for(Integer j:c0.badNumSet){
                    int v=j+sAry[i];
                    if(c1.oneNumSet.contains(v)){
                        c1.oneNumSet.remove(v);
                    }
                    c1.badNumSet.add(v);
                }
                for(Integer j:c0.oneNumSet){
                    int v=j+sAry[i];
                    if(c1.badNumSet.contains(v))continue;
                    if(c1.oneNumSet.contains(v)){
                        c1.oneNumSet.remove(v);
                        c1.badNumSet.add(v);
                        continue;
                    }
                    c1.oneNumSet.add(v);
                }
            }
        }
        
        int ret=0;
        for(Integer i:cellAry[m].oneNumSet){
            //System.out.println(i);
            ret+=i;
        }
        return ret;
    }
    
    public static void ans(){
        Scanner in = new Scanner(System.in);

        int n;int m;
        n=in.nextInt();
        m=in.nextInt();
        
        int[] sAry=new int[n];
        for(int i=0;i<n;++i){
            sAry[i]=in.nextInt();
        }
        
        int ret=cal(n,m,sAry);
        System.out.println(ret);
        in.close();
    }

    public static void test(){
        Random rand=new Random(0);
        for(int i=0;i<10;++i){
            int n=1+rand.nextInt(50);
            int m=1+rand.nextInt(n);
            int[] sAry=new int[n];
            for(int j=0;j<n;++j){
                sAry[j]=1+rand.nextInt(100);
            }
            //System.out.format("XCLMPNZI %d\n",i);
            //System.out.format("%d %d\n",n,m);
            //for(int s:sAry)System.out.format("%d ",s);
            //System.out.println();
            System.out.format("%d\n",cal(n,m,sAry));
        }
    }

    public static void main(String[] args){
        if(args.length==0){
            ans();
        }else{
            test();
        }
    }
    
}
