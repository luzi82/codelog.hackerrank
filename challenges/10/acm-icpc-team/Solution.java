import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        BitSet[] topicBsAry = new BitSet[topic.length];
        for(int i=0;i<topic.length;++i){
            char[] topicCharAry = topic[i].toCharArray();
            topicBsAry[i] = new BitSet(topicCharAry.length);
            for(int j=0;j<topicCharAry.length;++j){
                topicBsAry[i].set(j,topicCharAry[j]=='1');
            }
        }
        
        int maxCardinality=-1;
        int count=0;
        BitSet tmp = new BitSet(topicBsAry[0].size());
        for(int i=0;i<topic.length;++i){
            for(int j=0;j<i;++j){
                tmp.clear();
                tmp.or(topicBsAry[i]);
                tmp.or(topicBsAry[j]);
                if(tmp.cardinality()==maxCardinality){
                    ++count;
                }
                if(tmp.cardinality()>maxCardinality){
                    maxCardinality=tmp.cardinality();
                    count=1;
                }
            }
        }
        
        return new int[]{maxCardinality,count};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
