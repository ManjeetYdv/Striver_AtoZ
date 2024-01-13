class Pair{
    int node;
    long weight;
    public Pair(int node ,long weight){
        this.node=node;
        this.weight=weight;
    }
}
class Ways{
    long w;
    long ways;
    public Ways(long w , long ways){
        this.w=w;
        this.ways=ways;
    }
}
class Solution {
    int mod = (int)(1e9 +7);
    public int countPaths(int n, int[][] roads) {
       List<List<Pair>> adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++) adj.add(new ArrayList<>());
        for(int[]e : roads) {
            adj.get(e[0]).add(new Pair(e[1] , e[2]));
            adj.get(e[1]).add(new Pair(e[0] , e[2]));
        }
        
        Ways[] dist = new Ways[n];
        for(int i=0;i<n ;i++) dist[i] = new Ways(Long.MAX_VALUE , 0);
        dist[0].w=1;
        dist[0].ways=1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(int)(a.weight-b.weight));
        pq.add(new Pair(0 , 0));
        
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int node = p.node;
            long weight = p.weight;
            
            for(Pair neighbour : adj.get(node)){
                int neigh = neighbour.node;
                long w = neighbour.weight;
                long newW = w+weight;
                if(newW == dist[neigh].w) dist[neigh].ways= (dist[neigh].ways + dist[node].ways)%mod;
                else if(newW <dist[neigh].w) {
                    dist[neigh] = new Ways(newW , dist[node].ways);
                    pq.add(new Pair(neigh , newW));
                }
            }
        }
        return (int)dist[n-1].ways;
    }
}
