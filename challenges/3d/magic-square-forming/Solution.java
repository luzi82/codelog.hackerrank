import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[][][] sqList=new int[][][]{
        {{2,7,6},{9,5,1},{4,3,8}},
        {{2,9,4},{7,5,3},{6,1,8}},
        {{4,3,8},{9,5,1},{2,7,6}},
        {{4,9,2},{3,5,7},{8,1,6}},
        {{6,1,8},{7,5,3},{2,9,4}},
        {{6,7,2},{1,5,9},{8,3,4}},
        {{8,1,6},{3,5,7},{4,9,2}},
        {{8,3,4},{1,5,9},{6,7,2}}
    };

    static boolean checkSq(int[][] sq){
        int s;
        for(int i=0;i<3;++i){
            s=0;
            for(int j=0;j<3;++j){
                s+=sq[i][j];
            }
            if(s!=15)return false;
        }
        for(int i=0;i<3;++i){
            s=0;
            for(int j=0;j<3;++j){
                s+=sq[j][i];
            }
            if(s!=15)return false;
        }
        s=0;
        for(int j=0;j<3;++j){
            s+=sq[j][j];
        }
        if(s!=15)return false;
        s=0;
        for(int j=0;j<3;++j){
            s+=sq[j][2-j];
        }
        if(s!=15)return false;
        return true;
    }

    static int[][][] calAllMs(){
        List<int[][]> ret=new LinkedList<int[][]>();
        
        boolean[] used=new boolean[10];
        for(int a=1;a<=9;++a){
            used[a]=true;
            for(int b=1;b<=9;++b){
                if(used[b])continue;
                int c=15-a-b;
                if(c==b)continue;
                if(c<1)continue;
                if(c>9)continue;
                if(used[c])continue;
                used[b]=true;
                used[c]=true;
                for(int d=1;d<=9;++d){
                    if(used[d])continue;
                    int g=15-a-d;
                    if(g==d)continue;
                    if(g<1)continue;
                    if(g>9)continue;
                    if(used[g])continue;
                    used[d]=true;
                    used[g]=true;
                    for(int e=1;e<=9;++e){
                        if(used[e])continue;
                        if(c+e+g!=15)continue;
                        int f=15-d-e;
                        int h=15-b-e;
                        int i=15-c-f;
                        if(f<1)continue;
                        if(f>9)continue;
                        if(h<1)continue;
                        if(h>9)continue;
                        if(i<1)continue;
                        if(i>9)continue;
                        if(used[f])continue;
                        used[f]=true;
                        do{
                            if(used[h])break;
                            used[h]=true;
                            do{
                                if(used[i])break;
                                
                                int[][] sq=new int[][]{{a,b,c},{d,e,f},{g,h,i}};
                                if(!checkSq(sq))break;
                                ret.add(sq);
                            }while(false);
                            used[h]=false;
                        }while(false);
                        used[f]=false;
                    }
                    used[d]=false;
                    used[g]=false;
                }
                used[b]=false;
                used[c]=false;
            }
            used[a]=false;
        }
        
        return ret.toArray(new int[0][][]);
    }

    static int formingMagicSquare(int[][] s) {
        
        int ret=999999;
        for(int[][] sq:sqList){
            int v=0;
            for(int i=0;i<3;++i){for(int j=0;j<3;++j){
                v+=Math.abs(s[i][j]-sq[i][j]);
            }}
            if(v<ret)ret=v;
        }

        return ret;
    }

    public static void solve(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }

    public static void test(String[] args) {
        int[][][] allMs=calAllMs();
        for(int[][] ms:allMs){
            System.out.format("{{%d,%d,%d},{%d,%d,%d},{%d,%d,%d}},\n",
                ms[0][0],ms[0][1],ms[0][2],
                ms[1][0],ms[1][1],ms[1][2],
                ms[2][0],ms[2][1],ms[2][2]
            );
        }
    }

    public static void main(String[] args) {
        if(args.length>0){
            test(args);
        }else{
            solve(args);
        }
    }
}
