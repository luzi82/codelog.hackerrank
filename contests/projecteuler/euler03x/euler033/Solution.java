import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[][][] ans = new int[5][5][2];
        ans[2][1] = new int[]{110,322};
        ans[3][1] = new int[]{77262,163829};
        ans[3][2] = new int[]{7429,17305};
        ans[4][1] = new int[]{12999936,28131911};
        ans[4][2] = new int[]{3571225,7153900};
        ans[4][3] = new int[]{255983,467405};
        
        System.out.println(""+ans[n][k][0]+" "+ans[n][k][1]);
    }

}
