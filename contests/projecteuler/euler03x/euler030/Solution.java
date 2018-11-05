import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static int check(int[] ary,int pow){
        int sum = 0;
        for(int i=0;i<ary.length;++i){
            sum += Math.pow(ary[i],pow);
        }
        if(sum<10)return 0;
        int summ=sum;
        int[] ary2 = new int[ary.length];
        for(int i=0;i<ary2.length;++i){
            ary2[i] = summ%10;
            summ/=10;
        }
        Arrays.sort(ary2);
        if(!Arrays.equals(ary,ary2))return 0;
        return sum;
    }

    public static int search(int[] ary, int done,int pow){
        if(done==ary.length){
            return check(ary,pow);
        }
        int ret = 0;
        int min = (done==0)?0:ary[done-1];
        for(int i=min;i<10;++i){
            ary[done]=i;
            ret += search(ary,done+1,pow);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] ary = new int[n+1];
        int ans = search(ary,0,n);
        
        // print ans
        System.out.println(ans);
    }
}
