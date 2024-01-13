class Pair{
    int node , weight;
    public Pair(int node ,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++) adj.add(new ArrayList<>());

        for(int []e : times) adj.get(e[0]-1).add(new Pair(e[1]-1 , e[2]));
        int []dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k-1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(k-1 , 0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int weight = p.weight;
            
            for(Pair neighbour :adj.get(node)){
                int neigh = neighbour.node;
                int dis = neighbour.weight;
                
                if(weight + dis <dist[neigh]){
                    dist[neigh]=weight+dis;
                    pq.add(new Pair(neigh , dist[neigh]));
                }
            }
        }
        
        int min = 0;
        for(int ele : dist){
            if(ele == Integer.MAX_VALUE) return -1;
            else min = Math.max(min , ele);
        }
        return min;
    }
}
