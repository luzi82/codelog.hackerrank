import java.io.*;
import java.util.*;

public class Solution {

    public static int cal(int[][] numberAA){
        int n=numberAA.length;
        int[][] sumAA = new int[n][n];
        for(int j=0;j<n;++j)for(int k=0;k<=j;++k){
            if((j==0)&&(k==0)){
                sumAA[j][k] = numberAA[j][k];
            }else if(k==0){
                sumAA[j][k] = numberAA[j][k] + sumAA[j-1][k];
            }else if(k==j){
                sumAA[j][k] = numberAA[j][k] + sumAA[j-1][k-1];
            }else{
                sumAA[j][k] = numberAA[j][k] + Math.max(sumAA[j-1][k-1],sumAA[j-1][k]);
            }
        }
        int ret = 0;
        for(int k=0;k<n;++k){
            ret = Math.max(ret, sumAA[n-1][k]);
        }
        return ret;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            int n=scanner.nextInt();
            int[][] numberAA = new int[n][n];
            for(int j=0;j<n;++j)for(int k=0;k<=j;++k){
                numberAA[j][k] = scanner.nextInt();
            }
            int ans = cal(numberAA);
            System.out.println(ans);
        }
    }
}
