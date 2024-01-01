import java.util.*;
public class Solution 
{
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v ;i++) adj.add(new ArrayList<>());
        for(int []edge :edges)adj.get(edge[0]).add(edge[1]);

        int[]vis = new int[v];
        int[] pathVis = new int[v];
        
        for(int i=0 ;i<v ;i++){
            if(vis[i]==0){
                if(dfs(i , adj ,vis ,pathVis)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int node , List<List<Integer>>adj ,int []vis ,int[]pathVis){
        vis[node]=1;
        pathVis[node]=1;
        
        for(int neighbour : adj.get(node)){
            if(vis[neighbour]==0){
                if(dfs(neighbour ,adj ,vis , pathVis)) return true;
            }
            else if(pathVis[neighbour]==1) return true;
        }
        
        pathVis[node]=0;
        return false;
    }
}
