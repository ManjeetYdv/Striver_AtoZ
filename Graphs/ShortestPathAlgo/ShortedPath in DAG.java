import java.util.*;
class Pair{
    int node , weight;
    public Pair(int node ,int weight){
        this.node=node;
        this.weight=weight;
    }
}


// Finding the shortest path to a vertex is easy if you already know the shortest paths to all the vertices that can precede it. Finding the longest path to a vertex in DAG is easy if you already know the longest path to all the vertices that can precede it.

// Processing the vertices in topological order ensures that by the time you get to a vertex, you've already processed all the vertices that can precede it.

// Dijkstra's algorithm is necessary for graphs that can contain cycles, because they can't be topologically sorted.
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
