import java.io.*;
import java.util.*;

public class Solution {

    public static int getV(String name){
        int ret = 0;
        for(char c:name.toCharArray()){
            ret+=c-'a'+1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] nameAry = new String[n];
        for(int i=0;i<n;++i){
            nameAry[i] = scanner.nextLine().toLowerCase();
        }
        
        Arrays.sort(nameAry);
        
        int q = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<q;++i){
            String name = scanner.nextLine().toLowerCase();
            int idx = Arrays.binarySearch(nameAry, name);
            int value = getV(name);
            int score = (idx+1)*value;
            System.out.println(score);
        }
        
    }

}
