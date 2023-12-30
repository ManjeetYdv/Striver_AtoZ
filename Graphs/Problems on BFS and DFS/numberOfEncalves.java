class Solution {
    int [][] directions = {{1 , 0} ,{-1,0} ,{0,1} , {0,-1}} ;
    public boolean isValid(int i , int j , int m , int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
   
    public void dfs(int i ,int j , boolean [][]vis , int [][] board){
        if(!isValid(i ,j ,board.length , board[0].length )|| vis[i][j] || board[i][j]==0) return;
        vis[i][j]=true;
        board[i][j]=0;
        for(int []d :directions){
            int row=i+d[0];
            int col =j+d[1];
            dfs(row , col , vis , board);
        }
    }
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];


        for(int j=0 ;j<n ;j++){
            int row=0;
            dfs(row , j ,vis , board);
            row =m-1;
            dfs(row , j ,vis , board);
        }
        for(int i=0 ;i<m ;i++){
            int col=0;
            dfs(i , col , vis , board);
            col=n-1;
            dfs(i , col , vis ,board);
        }

        int res=0;
        for(int i=0 ;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                if (board[i][j]==1) res++;
            }
        }
        return res;
    }
}
