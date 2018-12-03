import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        for(int i=2;i<n;++i){
            if(isM(i,k)){
                System.out.println(i);
            }
        }
    }
    
    public static boolean isM(int v,int k){
        StringBuffer sb=new StringBuffer();
        int i=1;
        while(sb.length()<k){
            sb.append(Integer.toString(i*v));
            ++i;
        }
        if(sb.length()!=k)return false;
        char[] cv=sb.toString().toCharArray();
        boolean[] exist=new boolean[10];
        for(char c:cv){
            i=c-'0';
            if(i==0)return false;
            if(i>k)return false;
            if(exist[i])return false;
            exist[i]=true;
        }
        return true;
    }

}
