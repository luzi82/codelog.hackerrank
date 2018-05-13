public class CycleTest {

    public static void test(int p,int q){
        boolean[] touchA = new boolean[q];
        
        int ret=0;
        int v=1;
        while(true){
            if(touchA[v])break;
            touchA[v]=true;
            ++ret;
            v*=p;
            v%=q;
        }
        
        System.out.format("%d %d %d\n",p,q,ret);
    }
    
    public static void main(String[] args) {
        test(3,10007);
        test(5,10007);
        test(7,10009);
        test(11,10009);
    }

}
