import java.util.*;
class Pair{
    int node , weight;
    public Pair(int node ,int weight){
        this.node=node;
        this.weight=weight;
    }
}
public class Solution {
    public static void topoSort(int node ,int[]vis , List<List<Pair>> adj , Stack<Integer>stack){
        vis[node]=1;
        for(Pair p : adj.get(node)){
            int n = p.node;
            if(vis[n]==0){
                topoSort(n , vis , adj ,stack);
            }
        }
        stack.push(node);
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++) adj.add(new ArrayList<>());

        for(int []e : edges){
            adj.get(e[0]).add(new Pair(e[1] , e[2]));
        }
        int[]vis = new int[n];
        Stack<Integer> topo = new Stack<>();
        for(int i=0 ;i< n;i++){
            if(vis[i]==0) topoSort(i , vis ,adj , topo);
        }

        int[]dist = new int[n];
        Arrays.fill(dist , (int)1e9);
        dist[0]=0;

        while(!topo.isEmpty()){
            int node= topo.pop();

            for(Pair p : adj.get(node)){
                int neighbour = p.node;
                int weight = p.weight;
                if(dist[node]+weight < dist[neighbour]) {
                    dist[neighbour]=dist[node]+weight;
                }
            }
        }

        for(int i=0 ;i<n ;i++){
            if(dist[i]==(int)1e9) dist[i]=-1;
        }
        return dist;

    }
}
