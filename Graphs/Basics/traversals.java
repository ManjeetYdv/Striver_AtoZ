package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.InflaterInputStream;

public class bfs {

    public static List<Integer> bfs(int n ,List<List<Integer>> adj){
        boolean[]vis = new boolean [n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(0);
        vis[0]=true;
        while(!queue.isEmpty()){
            int vertix = queue.poll();
            list.add(vertix);

            for(int neighbour : adj.get(vertix)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
        return list;

    }
    public static void helper(int node , boolean []vis ,List<Integer> dfs ,  List<List<Integer>> adj){
        dfs.add(node);
        for(int vertix : adj.get(node)){
            if(!vis[vertix]){
                vis[vertix]=true;
                helper(vertix ,vis  , dfs , adj);
            }
        }
    }

    public static List<Integer> dfs(int start , int n , List<List<Integer>> adj){
        List<Integer> dfs = new ArrayList<>();
        boolean []vis = new boolean[n];
        vis[start]=true;
        helper(start , vis , dfs , adj);
        return dfs;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<5 ;i++){
            adj.add(new ArrayList<>());
        }
         adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        List<Integer> bfs = bfs(5 , adj);
//        System.out.println(bfs.size());
//        for(int i : bfs) System.out.print(i+" ");

        List<Integer> dfs = dfs(0 ,5 , adj);
        for(int i: dfs) System.out.print(i+" ");

    }
}
