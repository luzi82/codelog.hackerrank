import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    int[][] gAA;
    int mod;

    int[][] gSumAA;
    int pSum;
    int pw;
    int ph;

    int xFactor;
    int yFactor;
    int xyFactor;    

    public Solution(int[][] g, int[][] p, int xMulti, int yMulti, int mod){
        this.gAA = g;
        this.mod = mod;

        gSumAA = createSumAA(g, xMulti, yMulti, mod);

        pw=p.length;
        ph=p[0].length;
        pSum = createSumAA(p, xMulti, yMulti, mod)[pw][ph];

        xFactor=1;
        for(int i=0;i<pw;++i){
            xFactor*=xMulti;
            xFactor%=mod;
        }
        
        yFactor=1;
        for(int i=0;i<ph;++i){
            yFactor*=yMulti;
            yFactor%=mod;
        }
        
        xyFactor = (xFactor*yFactor)%mod;
        xFactor = (mod-xFactor)%mod;
        yFactor = (mod-yFactor)%mod;
        
        //debug();
    }
    
    void debug(){
        System.out.println("gAA");
        for(int[] gA:gAA){
            for(int g:gA){
                System.out.print(""+g+" ");
            }
            System.out.println();
        }
        System.out.println("gSumAA");
        for(int[] gSumA:gSumAA){
            for(int gSum:gSumA){
                System.out.print(""+gSum+" ");
            }
            System.out.println();
        }
        System.out.println("pSum "+pSum);
        System.out.println("xFactor "+xFactor);
        System.out.println("yFactor "+yFactor);
        System.out.println("xyFactor "+xyFactor);
    }

    static int[][] createSumAA(int[][] vAA, int xMulti, int yMulti, int mod){
        int w=vAA.length;
        int h=vAA[0].length;
        int[][] v0AA = new int[w][h+1];
        for(int i=0;i<w;++i){
            v0AA[i][0]=0;
            for(int j=0;j<h;++j){
                v0AA[i][j+1]=(v0AA[i][j]*yMulti+vAA[i][j])%mod;
            }
        }
        int[][] v1AA = new int[w+1][h+1];
        for(int j=0;j<=h;++j){
            v1AA[0][j]=0;
            for(int i=0;i<w;++i){
                v1AA[i+1][j]=(v1AA[i][j]*xMulti+v0AA[i][j])%mod;
            }
        }
        return v1AA;
    }

    boolean test(int x,int y){
        int sum = 0;
        sum += (gSumAA[x][y]*xyFactor)%mod;
        sum += (gSumAA[x+pw][y]*yFactor)%mod;
        sum += (gSumAA[x][y+ph]*xFactor)%mod;
        sum += (gSumAA[x+pw][y+ph])%mod;
        sum %= mod;
        return sum == pSum;
    }

    static int[][] getIntAA(String[] strA){
        int[][] ret=new int[strA.length][strA[0].length()];
        for(int i=0;i<strA.length;++i){
            char[] charA = strA[i].toCharArray();
            for(int j=0;j<charA.length;++j){
                ret[i][j] = charA[j]-'0';
            }
        }
        return ret;
    }
    
    static boolean comp(int[][] gAA,int[][] pAA, int x, int y){
        for(int i=0;i<pAA.length;++i)for(int j=0;j<pAA[0].length;++j){
            if(gAA[i+x][j+y]!=pAA[i][j])return false;
        }
        return true;
    }

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int[][] gAA = getIntAA(G);
        int[][] pAA = getIntAA(P);
        
        Solution s0 = new Solution(gAA,pAA,3,5,10007);
        Solution s1 = new Solution(gAA,pAA,7,11,10009);
        
        int ii = gAA.length-pAA.length;
        int jj = gAA[0].length-pAA[0].length;
        for(int i=0;i<=ii;++i)for(int j=0;j<=jj;++j){
            if(!s0.test(i,j))continue;
            if(!s1.test(i,j))continue;
            if(!comp(gAA,pAA,i,j))continue;
            return "YES";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
