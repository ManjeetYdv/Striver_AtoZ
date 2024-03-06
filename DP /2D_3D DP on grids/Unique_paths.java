class Solution {
    // public int helper(int m , int n ,int[][]dp){
    //     if(m==0 && n==0) return 1;
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int ways=0;
    //     if(m-1>=0) ways+=helper(m-1 ,n ,dp);
    //     if(n-1>=0) ways+=helper(m , n-1 ,dp);
    //     return dp[m][n]= ways;
    // }
    // public int uniquePaths(int m, int n) {
    //     int[][]dp= new int[m][n];
    //     for(int []row : dp)Arrays.fill(row ,-1);
    //     return helper(m-1 , n-1 ,dp);
    // }
    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                if(i-1>=0) dp[i][j]+=dp[i-1][j];
                if(j-1>=0) dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
