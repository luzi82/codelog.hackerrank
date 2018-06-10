import java.io.*;
import java.util.*;

public class Solution {

    static long[] factorialAry = new long[14];

    public static String cal(long n){
        --n;
    
        LinkedList<Character> remainCharList = new LinkedList<Character>();
        for(int i=0;i<13;++i){
            remainCharList.add((char)('a'+i));
        }
        
        StringBuilder ret = new StringBuilder();
        while(!remainCharList.isEmpty()){
            long factorial = factorialAry[remainCharList.size()-1];
            int charIdx = (int) (n / factorial);
            ret.append(remainCharList.remove(charIdx));
            n %= factorial;
        }
        
        return ret.toString();
    }

    public static void main(String[] args) {
        factorialAry[0]=1;
        for(int i=1;i<factorialAry.length;++i){
            factorialAry[i]=factorialAry[i-1]*i;
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;++i){
            long n=scanner.nextLong();
            String ans = cal(n);
            System.out.println(ans);
        }
    }
}
