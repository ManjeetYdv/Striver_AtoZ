import java.util.*;
class Pair{
    int node , weight;
    public Pair(int node ,int weight){
        this.node=node;
        this.weight=weight;
    }
}
public class Solution {
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        // Write your code here.
        List<List<Pair>> adj = new ArrayList<>();
        int n= vertices;
        for(int i=0 ;i<n ;i++) adj.add( new ArrayList<>());

        for(int []e : edge){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(source , 0));
        dist[source]=0;

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int d = pair.weight;
            int curr = pair.node;

            for(Pair p : adj.get(curr)){
                if(d+ p.weight <dist[p.node]){
                    dist[p.node] = d+ p.weight;
                    pq.add(new Pair(p.node , dist[p.node]));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int ele : dist) res.add(ele);
        return res;
    }
}
