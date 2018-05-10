import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    int n; int k; int r_q; int c_q; int[][] obstacles;
    
    public Solution(int n, int k, int r_q, int c_q, int[][] obstacles){
        this.n=n;
        this.k=k;
        this.r_q=r_q-1;
        this.c_q=c_q-1;
        this.obstacles=new int[obstacles.length][2];
        for(int i=0;i<obstacles.length;++i){
            this.obstacles[i]=new int[]{obstacles[i][0]-1,obstacles[i][1]-1};
        }
    }
    
    Map<Integer,SortedSet<Integer>> obstacleXSetYMap = new HashMap<Integer,SortedSet<Integer>>();
    Map<Integer,SortedSet<Integer>> obstacleYSetXMap = new HashMap<Integer,SortedSet<Integer>>();
    Map<Integer,SortedSet<Integer>> obstacleXSetXYMap = new HashMap<Integer,SortedSet<Integer>>();
    Map<Integer,SortedSet<Integer>> obstacleXSetXYYMap = new HashMap<Integer,SortedSet<Integer>>();

    public void obstacleAdd(Map<Integer,SortedSet<Integer>> obstacleASetBMap,int b,int a){
        SortedSet<Integer> obstacleASet = obstacleASetBMap.get(b);
        if(obstacleASet==null){
            obstacleASet=new TreeSet<Integer>();
            obstacleASetBMap.put(b,obstacleASet);
        }
        obstacleASet.add(a);
    }
    
    public Integer findGteMin(Map<Integer,SortedSet<Integer>> obstacleASetBMap,int b,int a){
        SortedSet<Integer> obstacleASet = obstacleASetBMap.get(b);
        if(obstacleASet==null)return null;
        obstacleASet=obstacleASet.tailSet(a);
        if(obstacleASet.isEmpty())return null;
        return obstacleASet.first();
    }
    
    public Integer findLtMax(Map<Integer,SortedSet<Integer>> obstacleASetBMap,int b,int a){
        SortedSet<Integer> obstacleASet = obstacleASetBMap.get(b);
        if(obstacleASet==null)return null;
        obstacleASet=obstacleASet.headSet(a);
        if(obstacleASet.isEmpty())return null;
        return obstacleASet.last();
    }
    
    public int cal(){
        // fill obstacle search struct
        for(int[] obstacle: obstacles){
            int x=obstacle[0];
            int y=obstacle[1];
            obstacleAdd(obstacleXSetYMap, y, x);
            obstacleAdd(obstacleYSetXMap, x, y);
            obstacleAdd(obstacleXSetXYMap, x+y, x);
            obstacleAdd(obstacleXSetXYYMap, x-y, x);
        }
        
        int qx = r_q;
        int qy = c_q;
        int ret=0;
        Integer b=null;
        
        // N
        b = findLtMax(obstacleYSetXMap, qx, qy);
        if(b==null)b=-1;
        //System.err.format("n  %d\n",qy-b-1);
        ret += qy-b-1;

        // NE
        b = findGteMin(obstacleXSetXYMap, qx+qy, qx);
        if(b==null)b=Math.min(qx+qy+1,n);
        //System.err.format("ne %d\n",b-qx-1);
        ret += b-qx-1;
        
        // E
        b = findGteMin(obstacleXSetYMap, qy, qx);
        if(b==null)b=n;
        //System.err.format("e  %d\n",b-qx-1);
        ret += b-qx-1;
        
        // SE
        b = findGteMin(obstacleXSetXYYMap, qx-qy, qx);
        if(b==null)b=Math.min(qx-qy+n, n);
        //System.err.format("se %d\n",b-qx-1);
        ret += b-qx-1;
        
        // S
        b = findGteMin(obstacleYSetXMap, qx, qy);
        if(b==null)b=n;
        //System.err.format("s  %d\n",b-qy-1);
        ret += b-qy-1;
        
        // SW
        b = findLtMax(obstacleXSetXYMap, qx+qy, qx);
        if(b==null)b=Math.max(qx+qy-n, -1);
        //System.err.format("sw %d\n",qx-b-1);
        ret += qx-b-1;
        
        // W
        b = findLtMax(obstacleXSetYMap, qy, qx);
        if(b==null)b=-1;
        //System.err.format("w  %d\n",qx-b-1);
        ret += qx-b-1;
        
        // NW
        b = findLtMax(obstacleXSetXYYMap, qx-qy, qx);
        if(b==null)b=Math.max(qx-qy-1, -1);
        //System.err.format("nw %d\n",qx-b-1);
        ret += qx-b-1;
        
        return ret;
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Solution s=new Solution(n,k,r_q,c_q,obstacles);
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
