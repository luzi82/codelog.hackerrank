import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static long ans=0;

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        TreeSet<Integer> avaliableDigiSet = new TreeSet<>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<=n;++i){
            avaliableDigiSet.add(i);
            sb.append("0");
        }
        dfs(sb,avaliableDigiSet,0);
        
        System.out.println(ans);
    }
    
    public static void dfs(StringBuffer prefix,TreeSet<Integer> avaliableDigiSet,int charIdx){
        if(avaliableDigiSet.size()==0){
            handlePandigital(prefix);
            return;
        }
    
        Integer[] avaliableDigiAry = avaliableDigiSet.toArray(new Integer[0]);
        for(Integer avaliableDigi : avaliableDigiAry){
            //if(prefix==0&&avaliableDigi==0)continue; // skip leading 0
            avaliableDigiSet.remove(avaliableDigi);
            prefix.setCharAt(charIdx,(char)('0'+avaliableDigi));
            dfs(prefix, avaliableDigiSet, charIdx+1);
            avaliableDigiSet.add(avaliableDigi);
        }
    }
    
    public static void handlePandigital(StringBuffer v){
        if(checkGood0(v)){
            ans+=Long.parseLong(v.toString());
        }
    }
    
    public static boolean checkGood0(StringBuffer v){
        String str = v.toString();
        if(!checkGood1(str,1,2))return false;if(str.length()<5)return true;
        if(!checkGood1(str,2,3))return false;if(str.length()<6)return true;
        if(!checkGood1(str,3,5))return false;if(str.length()<7)return true;
        if(!checkGood1(str,4,7))return false;if(str.length()<8)return true;
        if(!checkGood1(str,5,11))return false;if(str.length()<9)return true;
        if(!checkGood1(str,6,13))return false;if(str.length()<10)return true;
        if(!checkGood1(str,7,17))return false;
        
        return true;
    }
    

    public static boolean checkGood1(String str,int start,int div){
        String subStr = str.substring(start,start+3);
        int v = Integer.parseInt(subStr);
        return v%div == 0;
    }

}
