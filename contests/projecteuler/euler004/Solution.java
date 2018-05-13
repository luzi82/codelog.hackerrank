import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int get_abccba(int abc){
        int v=abc;
        int c=v%10;v/=10;
        int b=v%10;v/=10;
        return abc*1000+c*100+b*10+v;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int abc = n/1000;
            
            while(abc>100){
                int abccba = get_abccba(abc);
                if(abccba>=n){
                    --abc;continue;
                }
                int f=Math.max(100,abccba/999);
                boolean found = false;
                while(f<=999){
                    if(f*f>abccba)break;
                    if(abccba%f==0){
                        int d=abccba/f;
                        if((d>=100)&&(d<=999)){
                            found=true;break;
                        }
                    }
                    ++f;
                }
                if(found){
                    System.out.println(abccba);
                    break;
                }
                --abc;
            }
            if(abc<=100){
                throw new Error("fuck you");
            }
        }
    }
}
