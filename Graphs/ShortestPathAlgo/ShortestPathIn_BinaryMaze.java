sclass Node{
    int i;
    int j;
    int d;
    Node(int i , int j , int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    public boolean isValid(int i ,int j  ,int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1) return 1;
        int [][]direction = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int [][]vis = new int[n][n];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0 ,0 ,1));
        vis[0][0] =1;
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int i=node.i;
            int j=node.j;
            int d = node.d;

            for(int []dir : direction){
                int nrow = i+dir[0];
                int ncol = j+dir[1];
                if(nrow==n-1 && ncol==n-1) return d+1; 
                if(isValid(nrow , ncol  , n) && grid[nrow][ncol]==0 &&vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    queue.add(new Node(nrow , ncol , d+1));
                }
                
            }
        }
        return -1;
    }
}
