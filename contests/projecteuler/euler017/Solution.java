import java.io.*;
import java.util.*;

public class Solution {

    public static List<String> c1(String n1){
        LinkedList<String> ret = new LinkedList<String>();
        //if(n2.charAt(0)=='0'){ret.add("Zero");return ret;}
        if(n1.charAt(0)=='1'){ret.add("One");return ret;}
        if(n1.charAt(0)=='2'){ret.add("Two");return ret;}
        if(n1.charAt(0)=='3'){ret.add("Three");return ret;}
        if(n1.charAt(0)=='4'){ret.add("Four");return ret;}
        if(n1.charAt(0)=='5'){ret.add("Five");return ret;}
        if(n1.charAt(0)=='6'){ret.add("Six");return ret;}
        if(n1.charAt(0)=='7'){ret.add("Seven");return ret;}
        if(n1.charAt(0)=='8'){ret.add("Eight");return ret;}
        if(n1.charAt(0)=='9'){ret.add("Nine");return ret;}
        return ret;
    }

    public static List<String> c2(String n2){
        if(n2.charAt(0)=='0'){return c1(n2.substring(1,2));}
        LinkedList<String> ret = new LinkedList<String>();
        if(n2.equals("10")){ret.add("Ten");return ret;}
        if(n2.equals("11")){ret.add("Eleven");return ret;}
        if(n2.equals("12")){ret.add("Twelve");return ret;}
        if(n2.equals("13")){ret.add("Thirteen");return ret;}
        if(n2.equals("14")){ret.add("Fourteen");return ret;}
        if(n2.equals("15")){ret.add("Fifteen");return ret;}
        if(n2.equals("16")){ret.add("Sixteen");return ret;}
        if(n2.equals("17")){ret.add("Seventeen");return ret;}
        if(n2.equals("18")){ret.add("Eighteen");return ret;}
        if(n2.equals("19")){ret.add("Nineteen");return ret;}
        if(n2.charAt(0)=='2')ret.add("Twenty");
        if(n2.charAt(0)=='3')ret.add("Thirty");
        if(n2.charAt(0)=='4')ret.add("Forty");
        if(n2.charAt(0)=='5')ret.add("Fifty");
        if(n2.charAt(0)=='6')ret.add("Sixty");
        if(n2.charAt(0)=='7')ret.add("Seventy");
        if(n2.charAt(0)=='8')ret.add("Eighty");
        if(n2.charAt(0)=='9')ret.add("Ninety");
        ret.addAll(c1(n2.substring(1,2)));
        return ret;
    }

    public static List<String> c3(String n3, String end){
        LinkedList<String> ret = new LinkedList<String>();
        if(n3.equals("000"))return ret;
        if(n3.charAt(0)!='0'){
            ret.addAll(c1(n3.substring(0,1)));
            ret.add("Hundred");
        }
        ret.addAll(c2(n3.substring(1,3)));
        ret.add(end);
        return ret;
    }

    public static String cal(String n){
        n = "000000000000000"+n;
        n = n.substring(n.length()-15);
        if(n.equals("000000000000000"))return "Zero";
        LinkedList<String> retList = new LinkedList<String>();
        retList.addAll(c3(n.substring(0,3),"Trillion"));
        retList.addAll(c3(n.substring(3,6),"Billion"));
        retList.addAll(c3(n.substring(6,9),"Million"));
        retList.addAll(c3(n.substring(9,12),"Thousand"));
        retList.addAll(c3(n.substring(12,15),""));
        String[] retAry = retList.toArray(new String[0]);
        String ret = String.join(" ",retAry);
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<t;++i){
            String n = scanner.nextLine();
            String ans = cal(n);
            System.out.println(ans);
        }
    }
}
