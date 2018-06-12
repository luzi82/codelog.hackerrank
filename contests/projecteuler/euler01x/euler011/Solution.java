import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int v(int[][] grid,int i,int j){
        if(i<0)return 1;
        if(j<0)return 1;
        if(i>=20)return 1;
        if(j>=20)return 1;
        if(grid[i][j]==0)return 1;
        return grid[i][j];
    }
    
    public static int z(int[][] grid,int i,int j){
        if(i<0)return 1;
        if(j<0)return 1;
        if(i>=20)return 1;
        if(j>=20)return 1;
        if(grid[i][j]==0)return 1;
        return 0;
    }
    
    public static int val(int product,int zeroCount){
        return (zeroCount>0)?0:product;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        int ret = 0;
        // j++
        for(int i=0;i<20;++i){
            int product = 1;
            int zeroCount = 4;
            for(int j=0;j<20;++j){
                product/=v(grid,i,j-4);
                zeroCount-=z(grid,i,j-4);
                product*=v(grid,i,j);
                zeroCount+=z(grid,i,j);
                ret = Math.max(ret,val(product,zeroCount));
            }
        }
        // i++
        for(int j=0;j<20;++j){
            int product = 1;
            int zeroCount = 4;
            for(int i=0;i<20;++i){
                product/=v(grid,i-4,j);
                zeroCount-=z(grid,i-4,j);
                product*=v(grid,i,j);
                zeroCount+=z(grid,i,j);
                ret = Math.max(ret,val(product,zeroCount));
            }
        }
        
        // i++j++
        for(int ii=0;ii<20;++ii){
            int product = 1;
            int zeroCount = 4;
            int i=ii;
            int j=0;
            while((i>=0)&&(j>=0)&&(i<20)&&(j<20)){
                product/=v(grid,i-4,j-4);
                zeroCount-=z(grid,i-4,j-4);
                product*=v(grid,i,j);
                zeroCount+=z(grid,i,j);
                ret = Math.max(ret,val(product,zeroCount));
                ++i;++j;
            }
        }
        for(int jj=0;jj<20;++jj){
            int product = 1;
            int zeroCount = 4;
            int i=0;
            int j=jj;
            while((i>=0)&&(j>=0)&&(i<20)&&(j<20)){
                product/=v(grid,i-4,j-4);
                zeroCount-=z(grid,i-4,j-4);
                product*=v(grid,i,j);
                zeroCount+=z(grid,i,j);
                ret = Math.max(ret,val(product,zeroCount));
                ++i;++j;
            }
        }

        // i++(19-j++)
        for(int ii=0;ii<20;++ii){
            int product = 1;
            int zeroCount = 4;
            int i=ii;
            int j=0;
            while((i>=0)&&(j>=0)&&(i<20)&&(j<20)){
                product/=v(grid,i-4,19-(j-4));
                zeroCount-=z(grid,i-4,19-(j-4));
                product*=v(grid,i,19-j);
                zeroCount+=z(grid,i,19-j);
                ret = Math.max(ret,val(product,zeroCount));
                ++i;++j;
            }
        }
        for(int jj=0;jj<20;++jj){
            int product = 1;
            int zeroCount = 4;
            int i=0;
            int j=jj;
            while((i>=0)&&(j>=0)&&(i<20)&&(j<20)){
                product/=v(grid,i-4,19-(j-4));
                zeroCount-=z(grid,i-4,19-(j-4));
                product*=v(grid,i,19-j);
                zeroCount+=z(grid,i,19-j);
                ret = Math.max(ret,val(product,zeroCount));
                ++i;++j;
            }
        }
        
        System.out.println(ret);
    }
}
