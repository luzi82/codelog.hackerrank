import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Slow {

    int n; int k; int r_q; int c_q; int[][] obstacles;
    
    boolean[][] grid;
    
    public Slow(int n, int k, int r_q, int c_q, int[][] obstacles){
        this.n=n;
        this.k=k;
        this.r_q=r_q-1;
        this.c_q=c_q-1;
        this.obstacles=new int[obstacles.length][2];
        for(int i=0;i<obstacles.length;++i){
            this.obstacles[i]=new int[]{obstacles[i][0]-1,obstacles[i][1]-1};
        }

        this.grid = new boolean[n][n];
        for(int[] obstacle:this.obstacles){
            this.grid[obstacle[0]][obstacle[1]] = true;
        }
    }
    
    public int cal(){
        int qx = r_q;
        int qy = c_q;
        int ret=0;
        
        int x;int y;

        // N
        x=qx;y=qy;
        while(true){
            --y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }

        // NE
        x=qx;y=qy;
        while(true){
            ++x;
            --y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // E
        x=qx;y=qy;
        while(true){
            ++x;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // SE
        x=qx;y=qy;
        while(true){
            ++x;
            ++y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // S
        x=qx;y=qy;
        while(true){
            ++y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // SW
        x=qx;y=qy;
        while(true){
            --x;
            ++y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // W
        x=qx;y=qy;
        while(true){
            --x;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        // NW
        x=qx;y=qy;
        while(true){
            --x;
            --y;
            if(x<0)break;
            if(x>=n)break;
            if(y<0)break;
            if(y>=n)break;
            if(grid[x][y])break;
            ++ret;
        }
        
        return ret;
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Slow s=new Slow(n,k,r_q,c_q,obstacles);
        return s.cal();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
