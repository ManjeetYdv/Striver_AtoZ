class Solution {
    public int help(int i , int j , int [][]obstacleGrid , int m , int n , int[][]dp){
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int down =  help(i+1 , j , obstacleGrid , m , n , dp);
        int right  = help(i ,j+1 , obstacleGrid , m , n , dp) ;
        return dp[i][j] = down+right;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        
        int[][]dp = new int[m][n];
        for(int []a : dp) Arrays.fill(a , -1);
        return help(0 , 0 , obstacleGrid  , m , n , dp);
    }
}
