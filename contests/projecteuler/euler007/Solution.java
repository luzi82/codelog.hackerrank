import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int[] primeAry=new int[10010];
        primeAry[0] = 2;
        int primeCount=1;
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            while(n>primeCount){ // find more prime
                int p = primeAry[primeCount-1];
                ++p;
                while(true){ // try prime by +1
                    boolean good=true;
                    for(int i=0;i<primeCount;++i){ // test prime
                        if(p%primeAry[i]==0){good=false;break;}
                        if(primeAry[i]*primeAry[i]>p)break;
                    }
                    if(good)break;
                    ++p;
                }
                primeAry[primeCount]=p;
                ++primeCount;
            }
            System.out.println(primeAry[n-1]);
        }
        in.close();
    }
}
