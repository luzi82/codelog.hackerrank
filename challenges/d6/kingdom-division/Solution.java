import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static final long BIG=1000000000+7;
    
    static long[] dfs(int node,Integer parent,List<Integer>[] edgeListAry){
        List<Integer> edgeList=edgeListAry[node];
        
        // if leaf, return 1,0
        if((parent!=null)&&(edgeList.size()==1)){
            return new long[]{1,0};
        }
        
        List<long[]> abList=new LinkedList<long[]>();
        for(Integer child:edgeList){
            if(child==parent)continue;
            abList.add(dfs(child,node,edgeListAry));
        }
        
        long a=1;
        for(long[] ab:abList){
            a*=ab[1];
            a%=1000000000+7;
        }
        
        long b=1;
        for(long[] ab:abList){
            b*=(ab[0]+2*ab[1])%(1000000000+7);
            b%=1000000000+7;
        }
        b-=a;
        
        if(b<0){
            b+=1000000000+7;
        }
        
        return new long[]{a,b};
    }

    static int kingdomDivision(int n, int[][] roads) {
        if(n==1)return 2;
        if(n==2)return 2;
        if(n==3)return 2;
        
        // start from 1 is bad
        int[][] roadAry = new int[roads.length][2];
        for(int i=0;i<roads.length;++i){
            roadAry[i][0]=roads[i][0]-1;
            roadAry[i][1]=roads[i][1]-1;
        }
        
        // create better edge search struct
        List<Integer>[] edgeListAry = new List[n];
        for(int i=0;i<n;++i){
            edgeListAry[i] = new LinkedList<Integer>();
        }
        for(int[] r:roadAry){
            edgeListAry[r[0]].add(r[1]);
            edgeListAry[r[1]].add(r[0]);
        }
        
        Integer[][] edgeAryAry = new Integer[n][];
        for(int i=0;i<n;++i){
            edgeAryAry[i] = edgeListAry[i].toArray(new Integer[0]);
        }

        // dfs in while loop
        class Node{
            boolean done;
            int p;
            long a;
            long b;
            public Node(){p=-1;done=false;}
        }
        Node[] nodeAry = new Node[n];
        for(int i=0;i<n;++i){
            nodeAry[i]=new Node();
        }
        
        class Dfs{
            int node;
            int done;
            public Dfs(int i){node=i;done=0;}
        }
        Stack<Dfs> dfsStack=new Stack<Dfs>();
        dfsStack.push(new Dfs(0));
        
        while(true){
            if(dfsStack.size()==0)break;
            Dfs dfs=dfsStack.peek();
            Node node=nodeAry[dfs.node];
            int parent=node.p;
            Integer[] edgeAry=edgeAryAry[dfs.node];
            if(dfs.done==edgeAry.length){
                long a=1;long b=1;
                for(Integer edge:edgeAry){
                    if(edge==parent)continue;
                    Node childNode=nodeAry[edge];
                    a*=childNode.b;
                    a%=BIG;
                    b*=((childNode.a+2*childNode.b)%BIG);
                    b%=BIG;
                }
                if(b<a)b+=BIG;
                b-=a;
                node.a=a;node.b=b;
                dfsStack.pop();
                continue;
            }
            int child=edgeAry[dfs.done];
            ++dfs.done;
            if(child!=parent){
                nodeAry[child].p=dfs.node;
                dfsStack.push(new Dfs(child));
            }
        }
        
        long ret=nodeAry[0].b;
        ret*=2;
        ret%=BIG;
        return (int)ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] roads = new int[n-1][2];
        for(int roads_i = 0; roads_i < n-1; roads_i++){
            for(int roads_j = 0; roads_j < 2; roads_j++){
                roads[roads_i][roads_j] = in.nextInt();
            }
        }
        int result = kingdomDivision(n, roads);
        System.out.println(result);
        in.close();
    }
}
