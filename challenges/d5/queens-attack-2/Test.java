import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {

    public static void t(){
        Random r=new Random(0);
        int n=r.nextInt(4)+1;
        int k=r.nextInt(n*n);
        int r_q=r.nextInt(n);
        int c_q=r.nextInt(n);
        boolean[][] grid=new boolean[n][n];
        for(int i=0;i<k;++i){
            grid[r.nextInt(n)][r.nextInt(n)] = true;
        }
        grid[r_q][c_q]=false;
        k=0;
        for(int i=0;i<n;++i){for(int j=0;j<n;++j){
            if(grid[i][j])++k;
        }}
        int[][] obstacles=new int[k][2];
        int offset=0;
        for(int i=0;i<n;++i){for(int j=0;j<n;++j){
            if(!grid[i][j])continue;
            obstacles[offset][0]=i+1;
            obstacles[offset][1]=j+1;
            ++offset;
        }}
        
        int slow=Slow.queensAttack(n,k,r_q+1,c_q+1,obstacles);
        int solution=Solution.queensAttack(n,k,r_q+1,c_q+1,obstacles);
        if(slow!=solution){
            System.out.format("%d %d\n",n,k);
            System.out.format("%d %d\n",r_q+1,c_q+1);
            for(int[] obstacle:obstacles){
                System.out.format("%d %d\n",obstacle[0],obstacle[1]);
            }
            System.out.println();
            System.out.format("%d %d\n",slow,solution);
            throw new Error();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<100;++i){
            t();
        }
    }

}
