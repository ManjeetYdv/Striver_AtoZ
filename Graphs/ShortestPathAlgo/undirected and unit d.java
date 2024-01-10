import java.util.*;
class Duo{
    int node;
    int distance;
    Duo(int node , int distance){
        this.node =node;
        this.distance =distance;
    }
}
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n ;i++) adj.add(new ArrayList<>());
        
        for(int edge[] : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int []res = new int[n];
      //  System.out.println(adj);
        Arrays.fill(res ,-1); //will act as vis also
        Queue<Duo> queue = new LinkedList<>();
        queue.add(new Duo(src , 0));
        res[src]=0;
        while(!queue.isEmpty()){
            Duo duo = queue.poll();
            int node = duo.node;
            int d = duo.distance;
            

            for(int x : adj.get(node)){
                if(res[x]==-1){
                    res[x]=d+1;
                    queue.add(new Duo(x , d+1));
                }
            }
            
        }
        return res;
    }
}
