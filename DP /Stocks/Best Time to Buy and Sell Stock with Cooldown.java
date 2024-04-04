class Solution {
    // int[][]dp;
    // public int helper(int i , int []prices , int buy){
    //     if(i>=prices.length) return 0;
    //     if(dp[i][buy]!=-1) return dp[i][buy];
    //     int skip = helper(i+1  ,prices , buy); 
    //     int pick =0;
    //     if(buy==1) pick = -prices[i] + helper(i+1 , prices , 0);
    //     else pick = prices[i] + helper(i+2 , prices , 1);
    //     return dp[i][buy]= Math.max(skip , pick);
    // }
    // public int maxProfit(int[] prices) {
    //     dp = new int[prices.length][2];
    //     for(int []a : dp) Arrays.fill(a , -1);
    //     return helper(0 , prices , 1);
    // }
    public int maxProfit(int[] prices) {
        int [][]dp = new int[prices.length+2][2];
        int n = prices.length;
        //can space optimize it using ahead1  , ahead2 , curr
        for(int i=n-1 ;i>=0 ;i--){
            dp[i][0] = Math.max(dp[i+1][0] , prices[i] + dp[i+2][1]);
            dp[i][1] = Math.max(dp[i+1][1] , -prices[i] + dp[i+1][0]);
        }
        return dp[0][1];
    }
}
