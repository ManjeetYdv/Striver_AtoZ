class Solution {
    public void dfs(int node , int[][]graph , int[]vis , int[]pathVis , int[]notSafe){
        vis[node]=1;
        pathVis[node]=1;
        
        for(int i=0 ;i<graph[node].length ;i++){
            if(vis[graph[node][i]]==0){
                dfs(graph[node][i] , graph ,vis, pathVis , notSafe);
            }
            else if(pathVis[graph[node][i]]==1 || notSafe[graph[node][i]]==1){
                //cycle or a neightour with leads to cycle
                for(int k=0 ;k<pathVis.length ;k++){
                    if(pathVis[k]==1) notSafe[k]=1;
                }
            }
        }
        pathVis[node]=0;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[]vis = new int[n];
        int[] pathVis = new int[n];
        int[] notSafe = new int[n];
        
        for(int i=0 ;i<n ;i++){
            if(vis[i]==0){
                dfs(i , graph , vis , pathVis , notSafe );
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<n ;i++){
            if(notSafe[i]==0) list.add(i);
        }
        return list;
    }
}
