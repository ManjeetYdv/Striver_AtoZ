class Solution {
    public int helper(int i , int j ,int [][]grid , int[][]dp){
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int min=(int)1e9;
        if(i+1<grid.length) min = Math.min(min ,helper(i+1 ,j ,grid ,dp));
        if(j+1<grid[0].length) min = Math.min(min ,helper(i , j+1 , grid ,dp));
        return dp[i][j] =min + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int []r : dp) Arrays.fill(r ,-1);
        return helper(0 ,0,grid ,dp);
    }
}
