class Solution {
   int[][]directions = {{1,-1},{1,0},{1,1}};
   public int helper(int i  , int j, int n , int [][]matrix , int [][]dp){
        if(i==n) return 0;
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int min=(int)1e9;
        for(int []d : directions){
            int nrow =i+d[0];
            int ncol =j+d[1];
            if(ncol<n && ncol>=0) min = Math.min(min , helper(nrow , ncol, n , matrix , dp));
        }
        return dp[i][j]= min+matrix[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][]dp = new int[n][n];
        for(int[]row : dp) Arrays.fill(row , Integer.MAX_VALUE);

        int result=(int)1e9;
        for(int i=0 ;i<n ;i++)  result = Math.min(result , helper(0 , i , n , matrix  , dp));
        return result;

    }
}
