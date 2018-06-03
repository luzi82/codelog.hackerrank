import java.io.*;
import java.util.*;

public class Solution {

    public static int cal(long sy,int sm,int sd,long ey,int em,int ed) {
        int sy0 = (int)(sy%2800);
        if(sy0<1900)sy0+=2800;
        long syDiff = sy-sy0;
        int ey0 = (int)(ey-syDiff);
        
        GregorianCalendar calendar = new GregorianCalendar(sy0,sm-1,sd);
        GregorianCalendar endCalendar = new GregorianCalendar(ey0,em-1,ed);
        
        if(calendar.get(Calendar.DAY_OF_MONTH)!=1){
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.add(Calendar.MONTH,1);
        }
        
        int ans = 0;
        while(calendar.compareTo(endCalendar)<=0){
            if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                ++ans;
            }
            calendar.add(Calendar.MONTH,1);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t=scanner.nextInt();
        for(int i=0;i<t;++i){
            long sy = scanner.nextLong();
            int sm = scanner.nextInt();
            int sd = scanner.nextInt();
            long ey = scanner.nextLong();
            int em = scanner.nextInt();
            int ed = scanner.nextInt();
            long ans = cal(sy,sm,sd,ey,em,ed);
            System.out.println(ans);
        }
    
    }
}
