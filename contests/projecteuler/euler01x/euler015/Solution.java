import java.io.*;
import java.util.*;

public class Solution {
    
    public static final long BIG=1000000007;
    
    public static final int NCRLEN=510;
    public static long[][] ncr=new long[NCRLEN][NCRLEN];

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        for(int i=0;i<NCRLEN;++i)for(int j=0;j<NCRLEN;++j){
            if(i==0){
                ncr[i][j]=1;
            }else if (j==0){
                ncr[i][j]=1;
            }else{
                ncr[i][j]=(ncr[i-1][j]+ncr[i][j-1])%BIG;
            }
        }        
        
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            long ans = ncr[n][m];
            System.out.println(ans);
        }
    }
}
