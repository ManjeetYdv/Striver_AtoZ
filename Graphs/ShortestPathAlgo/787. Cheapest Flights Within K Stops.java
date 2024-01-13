class pair{
    int node;
    int d;
    pair(int node , int d){
        this.node=node;
        this.d=d;
    }
}
class Flight{
    int node;
    int dis;
    int k;
    Flight(int node , int dis ,int k){
        this.node=node;
        this.dis=dis;
        this.k=k;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++) adj.add(new ArrayList<>());
        
        int[]dis = new int[n];
        Arrays.fill(dis , Integer.MAX_VALUE);
        for(int []f : flights) adj.get(f[0]).add(new pair(f[1]  ,f[2]));
        
        Queue<Flight> pq = new LinkedList<>(); //dont use pq , dry run failed example or striver video , you want pq based on stops not distance , and for that queue is sufficent ,  bcz stops will be increasing by 1 each time
        dis[src]=0;
        pq.add(new Flight(src , 0 , 0));
        
        while(!pq.isEmpty()){
            Flight f = pq.poll();
            int node = f.node;
            int d = f.dis;
            int stops = f.k;
          
            if(stops>k) continue;
            
            for(pair p : adj.get(node)){
                int neighbour = p.node;
                int distance = p.d;
                if(distance+d < dis[neighbour]){
                    dis[neighbour] = distance +d;
                    pq.add(new Flight(neighbour , dis[neighbour] , stops+1));
                }
            }
        }
        return dis[dst]==Integer.MAX_VALUE ?-1 : dis[dst];
    }
}
