import java.io.*;
import java.util.*;
import java.math.*;

public class Solution0 {

    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        LinkedList<int[]> permutationList=new LinkedList<>();
        fillPermutationList(permutationList,new int[n-k],0,0,n-k,n);

        //System.err.println("KVZTQRFRDK");
        
        int minDtr = (int)Math.pow(10,n-1);
        int maxDtr = (int)Math.pow(10,n)-1;
        
        int ntrSum=0;
        int dtrSum=0;
        
        for(int dtr=minDtr;dtr<=maxDtr;++dtr){
            for(int ntr=minDtr;ntr<dtr;++ntr){
                if(cancelExist(ntr,dtr,k,n,permutationList)){
                    dtrSum+=dtr;
                    ntrSum+=ntr;
                }
            }
        }
        
        System.out.println(""+ntrSum+" "+dtrSum);
    }
    
    public static void fillPermutationList(LinkedList<int[]> permutationList, int[] permutation, int done, int used, int r, int n){
        if((n-used)<(r-done))return;
        if(done==r){
            permutationList.add(permutation.clone());
            return;
        }
        // use
        permutation[done] = used;
        fillPermutationList(permutationList,permutation,done+1,used+1,r,n);
        
        // no use
        fillPermutationList(permutationList,permutation,done,used+1,r,n);
    } 

    public static boolean cancelExist(int ntr,int dtr,int k,int n,LinkedList<int[]> permutationList){
        int[] ntrDigi = breakDigi(ntr,n);
        for(int[] permutation : permutationList){
            int ntr2 = joinDigi(ntrDigi, permutation);
            if(ntr2==0)continue;
            if((dtr*ntr2)%ntr!=0)continue;
            int dtr2 = (dtr*ntr2)/ntr;
            int[] ntrDigiTCancel = canceledDigiT(ntrDigi, permutation);
            if(ntrDigiTCancel[0]>0)continue;
            int[] dtrDigi=breakDigi(dtr,n);
            int[] dtr2Digi=breakDigi(dtr2,n-k);
            if(dtr2Digi==null)continue;
            int[] dtrDigiTCancel = checkCancelDigiT(dtrDigi, dtr2Digi);
            if(dtrDigiTCancel==null)continue;
            if(!Arrays.equals(dtrDigiTCancel,ntrDigiTCancel))continue;
            //System.err.println(""+ntr+" "+ntr2+" "+dtr+" "+dtr2);
            return true;
        }
        return false;
    }
    
    public static int[] breakDigi(int v,int n){
        int[] ret = new int[n];
        for(int i=n-1;i>=0;--i){
            ret[i] = v%10;
            v/=10;
        }
        if(v!=0)return null;
        return ret;
    }
    
    public static int joinDigi(int[] digi,int[] permutation){
        int ret=0;
        for(int i:permutation){
            ret*=10;
            ret+=digi[i];
        }
        return ret;
    }

    public static int[] canceledDigiT(int[] digi,int[] permutation){
        int[] ret = new int[10];
        for(int i:digi){
            ++ret[i];
        }
        for(int i:permutation){
            --ret[digi[i]];
        }
        return ret;
    }
    
    public static int[] breakDigiT(int v,int n){
        int[] ret = new int[10];
        for(int i=0;i<n;++i){
            ++ret[v%10];
            v/=10;
        }
        return ret;
    }
    
    public static int[] checkCancelDigiT(int[] dtrDigi, int[] dtr2Digi){
        int[] ret=new int[10];
        int a=0;int b=0;
        while((a<dtrDigi.length) || (b<dtr2Digi.length)){
            if(b>=dtr2Digi.length){
                ++ret[dtrDigi[a]];
                ++a;
                continue;
            }
            if(a>=dtrDigi.length){
                return null;
            }
            if(dtrDigi[a]==dtr2Digi[b]){
                ++a;++b;
                continue;
            }
            ++ret[dtrDigi[a]];
            ++a;
        }
        return ret;
    }

}
