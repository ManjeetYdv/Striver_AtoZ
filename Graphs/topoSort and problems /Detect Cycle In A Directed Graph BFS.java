import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<n ;i++) adj.add(new ArrayList<>());
        
        for(ArrayList<Integer> e : edges){
            adj.get(e.get(0)-1).add(e.get(1)-1);
        }
        
        int[] inDegree = new int[n];
        for(List<Integer> list : adj){
            for(int node : list){
                inDegree[node]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<n ;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        
        int cnt=0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            cnt++;
            
            for(int node : adj.get(curr)){
                inDegree[node]--;
                if(inDegree[node]==0) queue.add(node);
            }
        }
        return cnt!=n;
  }
}
