import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int iMax1 = matrix.size();
        int jMax1 = matrix.get(0).size();
        
        int[][] iToJToVAryAryIn = new int[iMax1][jMax1];
        int i=0;int j=0;
        for(List<Integer> vList:matrix){
            j=0;
            for(int v:vList){
                iToJToVAryAryIn[i][j] = v;
                ++j;
            }
            ++i;
        }
        
        int[][] iToJToVAryAryOut = new int[iMax1][jMax1];
        
        for(i=0;i<iMax1;++i)for(j=0;j<jMax1;++j){
            int[] lk=ijToLk(new int[]{i,j},iMax1,jMax1);
            // System.err.println(String.format("YDKLLZWB lk=%d,%d",lk[0],lk[1]));
            lk[1]+=r;
            int[] ij=lkToIj(lk,iMax1,jMax1);
            // System.err.println(String.format("DTMDILVT ij=%d,%d",ij[0],ij[1]));
            iToJToVAryAryOut[i][j] = iToJToVAryAryIn[ij[0]][ij[1]];
        }
        
        matrix.clear();
        
        for(int[] jToVAry:iToJToVAryAryOut){
            List<Integer> vList = new LinkedList<Integer>();
            for(int v:jToVAry){
                vList.add(v);
            }
            matrix.add(vList);
        }
    }

    public static int[] ijToLk(int[] ij,int iMax1,int jMax1){
        int i = ij[0];
        int j = ij[1];
    
        int iMax0=iMax1-1;
        int jMax0=jMax1-1;
        int l = Integer.MAX_VALUE;
        l = Math.min(l,i);
        l = Math.min(l,j);
        l = Math.min(l,iMax0-i);
        l = Math.min(l,jMax0-j);
        
        int i0 = l;
        int i1 = iMax0-l;
        int i2 = iMax1-l;
        int iLen = i2-i0;
        int j0 = l;
        int j1 = jMax0-l;
        int j2 = jMax1-l;
        int jLen = j2-j0;
        int k0 = 0;
        int k1 = jLen-1;
        int k2 = iLen+jLen-2;
        int k3 = iLen+2*jLen-3;
        int k4 = 2*iLen+2*jLen-4;
        
        // System.err.println(String.format("LZSXIIQY i0=%d,i1=%d,i2=%d,iLen=%d",i0,i1,i2,iLen));
        // System.err.println(String.format("SOXTIZRC j0=%d,j1=%d,j2=%d,jLen=%d",j0,j1,j2,jLen));
        // System.err.println(String.format("OINGJJLQ k0=%d,k1=%d,k2=%d,k3=%d,k4=%d",k0,k1,k2,k3,k4));
        
        int k = -1;
        if(i==i0){
            // System.err.println("NUMITXYA i==i0");
            k = j-j0+k0;
        }else if(j==j1){
            // System.err.println("HNVNBELR j==j1");
            k = i-i0+k1;
        }else if(i==i1){
            // System.err.println("ZVQXUNFN i==i1");
            k = (j1-j)+k2;
        }else{
            // System.err.println("NSLSXBAR else");
            k = (i1-i)+k3;
        }
        
        return new int[]{l,k};
    }
    
    public static int[] lkToIj(int[] lk,int iMax1,int jMax1){
        int l=lk[0];
        int k=lk[1];
        
        int iMax0=iMax1-1;
        int jMax0=jMax1-1;
        
        int i0 = l;
        int i1 = iMax0-l;
        int i2 = iMax1-l;
        int iLen = i2-i0;
        int j0 = l;
        int j1 = jMax0-l;
        int j2 = jMax1-l;
        int jLen = j2-j0;
        int k0 = 0;
        int k1 = jLen-1;
        int k2 = iLen+jLen-2;
        int k3 = iLen+2*jLen-3;
        int k4 = 2*iLen+2*jLen-4;
        
        k %= k4;
        k += k4;
        k %= k4;
        
        int i=-1;int j=-1;
        if(k<=k1){
            i=i0;
            j=k+j0;
        }else if(k<=k2){
            i=(k-k1)+i0;
            j=j1;
        }else if(k<=k3){
            i=i1;
            j=j1-(k-k2);
        }else{
            i=i1-(k-k3);
            j=j0;
        }
        
        return new int[]{i,j};
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);
        
        for(List<Integer> vList : matrix){
            boolean isFirst = true;
            for(int v:vList){
                if(!isFirst){System.out.print(" ");}
                isFirst=false;
                System.out.print(Integer.toString(v));
            }
            System.out.println("");
        }

        bufferedReader.close();
    }
}
