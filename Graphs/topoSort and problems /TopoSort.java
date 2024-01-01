
import java.util.*;
public class Solution {

    public static void dfs(int node , List<List<Integer>>adj ,int[]vis ,List<Integer> res){
        vis[node]=1;
        for(int neighbour : adj.get(node)){
            if(vis[neighbour]==0){
                dfs(neighbour , adj , vis , res);
            }
        }
        res.add(node);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<v ;i++) adj.add(new ArrayList<>());
        for(int []edge : edges) adj.get(edge[0]).add(edge[1]);
        
        int[]vis = new int[v];
        for(int i=0 ;i<v ;i++){
            if(vis[i]==0) dfs(i , adj ,vis ,res);
        }
        
        Collections.reverse(res);
        return res;
        
        

    }

}
