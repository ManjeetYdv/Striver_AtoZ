class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int m=matrix.length;
        // int n=matrix[0].length;
        // int[][]dp = new int[m][n];
        // for(int j=0 ;j<n ;j++) dp[0][j]=matrix[0][j];

        // for(int i=1;i<m ;i++){
        //     for(int j=0 ;j<n ;j++){
        //         dp[i][j] = matrix[i][j]+ dp[i-1][j];
        //         if(j-1>=0) dp[i][j] = Math.min(dp[i][j] ,matrix[i][j]+ dp[i-1][j-1]);
        //         if(j+1<n) dp[i][j] = Math.min(dp[i][j] , matrix[i][j]+ dp[i-1][j+1]);
        //     }
        // }
        // int res=dp[m-1][0];
        // for(int j=1;j<n ;j++) res = Math.min(res , dp[m-1][j]);
        // return res;
        int m=matrix.length;
        int n=matrix[0].length;
        int []prev = new int[n];
        
        for(int j=0 ;j<n ;j++) prev[j]=matrix[0][j];
        
        for(int i=1;i<m ;i++){
            int []curr = new int[n];
            for(int j=0 ;j<n ;j++){
                curr[j] = matrix[i][j]+ prev[j];
                if(j-1>=0) curr[j] = Math.min(curr[j] ,matrix[i][j]+ prev[j-1]);
                if(j+1<n) curr[j] = Math.min(curr[j] , matrix[i][j]+ prev[j+1]);
            }
            prev=curr;
        }
        int res=prev[0];
        for(int j=1;j<n ;j++) res = Math.min(res ,prev[j]);
        return res;
        
    }   

}
