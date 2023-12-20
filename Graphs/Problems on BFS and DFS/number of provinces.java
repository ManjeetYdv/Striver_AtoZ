class Solution {
    public void dfs(int node , boolean[]vis , int n , int [][]isConnected){
        for(int i=0 ;i<n ;i++){
          if(isConnected[node][i]==1 && !vis[i]){
              vis[i]=true;
              dfs(i , vis , n ,isConnected);
          }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int n = isConnected.length;
        boolean []vis = new boolean[n];

        for(int i=0 ;i<n ;i++){
            if(!vis[i]){
                provinces++;
                dfs(i , vis, n,  isConnected);
            }
        }
        return provinces;

    }
}
