package Graph;

import java.util.ArrayList;
import java.util.List;

public class cycleDetection {
    //using dfs
    public static boolean dfs(int parent , int node , List<List<Integer>> adj , int[]vis){
        vis[node]=1;
        for(int children : adj.get(node)) {
            if(vis[children]==0){
                if(dfs(node , children , adj , vis)) return true;
            }
            else{
                if(children!=parent) return true;
            }
        }
        return false;
    }

    public static boolean check(int n  ,List<List<Integer>> adj){
        int[] vis = new int[n];

        for(int i= 0;i<n ;i++){
            if(vis[i]==0) if(dfs(-1 , i , adj , vis))  return true;
        }
        return false;
    }

    public static void addEdge(int i , int j , List<List<Integer>> adj){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<5 ;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,adj);
        addEdge(1,2 ,adj);
        addEdge(2,3,adj);
        addEdge(3 , 1 ,adj);

        System.out.println(check(5 , adj));

    }
}
