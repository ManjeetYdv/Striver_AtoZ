import java.util.*;
class Current{
    int num;
    int lvl;
    public Current(int num ,int lvl){
        this.num=num;
        this.lvl=lvl;
    }
}
public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        if(start==end) return 0;
        Queue<Current> queue = new LinkedList<>();
        int []dist = new int[1001];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[start]=0;
        queue.add(new Current(start ,0));
        int mod=1000;

        while(!queue.isEmpty()){
            Current curr = queue.poll();
            int num =curr.num;
            int level = curr.lvl;

            for(int ele : a){
                int temp =(num*ele) %mod;
                if(level+1 <dist[temp]){
                    dist[temp] =level+1;
                    if(temp==end) return level+1;
                    queue.add(new Current(temp , level+1));
                }
            }
        }
        return -1;
    }
}
