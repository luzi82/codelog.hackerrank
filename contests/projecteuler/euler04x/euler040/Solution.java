import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static long BIG = 1000000000000000000L;

    public static long[] s = new long[19];
    public static long[] b = new long[19];

    public static void main(String[] args) {
        // prepare
        long s9=9;
        s[0]=0;
        b[0]=0;
        s[1]=1;
        b[1]=1;
        for(int i=2;true;++i){
            s[i]=s[i-1]+s9*(i-1);
            b[i]=b[i-1]*10;
            //System.out.println(String.format("%d %d %d",i,s[i],b[i]));
            if(s[i]>BIG)break;
            s9*=10;
        }
    
        // input
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for(int tt=0;tt<t;++tt){
            int ans=1;
            for(int i=0;i<7;++i){
                long v=scanner.nextLong();
                int dd = getD(v);
                ans*=dd;
            }
            System.out.println(ans);
        }
    }
    
    public static int getD(long v){
        int d=Arrays.binarySearch(s,v);
        if(d<0){d=-d-2;}
        long idx=v-s[d];
        long num=idx/d+b[d];
        int mod=(int)(idx%d);
        String numStr=Long.toString(num);
        int ret = numStr.toCharArray()[mod]-'0';
        //System.out.println(String.format("v=%d,d=%d,idx=%d,num=%d,mod=%d,ret=%d",v,d,idx,num,mod,ret));
        return ret;
    }

}
