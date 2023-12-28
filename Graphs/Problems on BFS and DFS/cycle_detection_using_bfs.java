package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int curr;
    int parent;
    public Node(){}
    public Node(int curr , int parent){
        this.curr = curr;
        this.parent = parent;
    }
}
public class cycleDetection {
    //using bfs
    public static boolean bfs(int currNode , List<List<Integer>> adj , boolean []vis){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(currNode , -1));
        vis[currNode] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int curr = node.curr;
            int parent = node.parent;

            for(int neighbour : adj.get(curr)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    queue.add(new Node(neighbour , curr));
                }
                else if(neighbour!=parent) return true;
            }
        }
        return false;
    }
    boolean detectCycle(int n, List<List<Integer>> adj) {
        // Write your code here.
        boolean []vis = new boolean[n];
        for(int i=0 ;i<n ;i++){
            if(!vis[i]) if(bfs(i , adj , vis)) return true;
        }
        return false;
    }
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
