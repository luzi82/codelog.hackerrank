import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Dncret{
        public DncretM[] mAry;
        public Dncret(int m){mAry=new DncretM[m+1];}
    }
    static class DncretM{
        public Set<Integer> oneNumSet=new HashSet<Integer>();
        public Set<Integer> badNumSet=new HashSet<Integer>();
    }
    
//    static Dncret dnc(int n0,int n1,int m,int[] sAry){
//        Dncret ret=_dnc(n0,n1,m,sAry);
//        //System.out.format("IMIBSAMT dnc n0=%d n1=%d m=%d\n",n0,n1,m);
//        //for(int i=0;i<=m;++i){
//        //    if(ret.mAry[i]==null)continue;
//        //    //System.out.format("GCZBDZYQ mm=%d, one=%d, bad=%d\n",i,ret.mAry[i].oneNumSet.size(),ret.mAry[i].badNumSet.size());
//        //}
//        return ret;
//    }
    
    static Dncret dnc(int n0,int n1,int m,int[] sAry){
        Dncret ret=new Dncret(m);
        DncretM dm;
        int d=n1-n0;

        if(d==1){
            // m=0
            dm=new DncretM();
            dm.oneNumSet.add(0);
            ret.mAry[0]=dm;
            
            // m=1
            dm=new DncretM();
            dm.oneNumSet.add(sAry[n0]);
            ret.mAry[1]=dm;
            
            return ret;
        }
        
        int mid = (n0+n1)/2;
        Dncret lhs=dnc(n0,mid,m,sAry);
        Dncret rhs=dnc(mid,n1,m,sAry);
        
        int m0=Math.max(0,d+m-sAry.length);
        int m1=Math.min(m,d);
        
        //System.out.format("MLMAYSWI dnc n0=%d n1=%d m=%d m0=%d m1=%d\n",n0,n1,m,m0,m1);
        
        for(int mm=m0;mm<=m1;++mm){
            //System.out.format("XYPXXYPJ dnc n0=%d n1=%d m=%d mm=%d\n",n0,n1,m,mm);
            dm=new DncretM();
            
            int i0=Math.max(0,mm-n1+mid);
            int i1=Math.min(mm,mid-n0);
            
            // fill bad
            for(int i=i0;i<=i1;++i){
                int j=mm-i;
                //System.out.format("UKWFPDOK dnc n0=%d n1=%d m=%d mm=%d i=%d j=%d\n",n0,n1,m,mm,i,j);
                for(int l:lhs.mAry[i].badNumSet){
                    for(int r:rhs.mAry[j].badNumSet){
                        dm.badNumSet.add(l+r);
                    }
                }
                for(int l:lhs.mAry[i].badNumSet){
                    for(int r:rhs.mAry[j].oneNumSet){
                        dm.badNumSet.add(l+r);
                    }
                }
                for(int l:lhs.mAry[i].oneNumSet){
                    for(int r:rhs.mAry[j].badNumSet){
                        dm.badNumSet.add(l+r);
                    }
                }
            }
            
            // fill one
            for(int i=i0;i<=i1;++i){
                int j=mm-i;
                for(int l:lhs.mAry[i].oneNumSet){
                    for(int r:rhs.mAry[j].oneNumSet){
                        int v=l+r;
                        if(dm.badNumSet.contains(v))continue;
                        if(dm.oneNumSet.contains(v)){
                            dm.oneNumSet.remove(v);
                            dm.badNumSet.add(v);
                            continue;
                        }
                        dm.oneNumSet.add(v);
                    }
                }
            }
            
            ret.mAry[mm]=dm;
            //System.out.format("PAPTWEVC dnc n0=%d n1=%d m=%d mm=%d\n",n0,n1,m,mm);
        }
        return ret;
    }

    static int cal(int n,int m,int[] sAry){
        Arrays.sort(sAry);

        Dncret dncret = dnc(0,n,m,sAry);

        int ret=0;
        for(int i:dncret.mAry[m].oneNumSet){
            ret+=i;
        }
        return ret;
    }

    public static void ans(){
        Scanner in = new Scanner(System.in);

        int n;int m;
        n=in.nextInt();
        m=in.nextInt();
        
        int[] sAry=new int[n];
        for(int i=0;i<n;++i){
            sAry[i]=in.nextInt();
        }
        
        int ret=cal(n,m,sAry);
        System.out.println(ret);
        in.close();
    }

    public static void test(){
        Random rand=new Random(0);
        for(int i=0;i<10;++i){
            int n=1+rand.nextInt(50);
            int m=1+rand.nextInt(n);
            int[] sAry=new int[n];
            for(int j=0;j<n;++j){
                sAry[j]=1+rand.nextInt(100);
            }
            //System.out.format("XCLMPNZI %d\n",i);
            //System.out.format("%d %d\n",n,m);
            //for(int s:sAry)System.out.format("%d ",s);
            //System.out.println();
            System.out.format("%d\n",cal(n,m,sAry));
        }
    }

    public static void main(String[] args){
        if(args.length==0){
            ans();
        }else{
            test();
        }
    }
    
}
