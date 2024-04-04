class Solution {
   // 2 transaction = 4 buy and sell
    // public int helper(int i , int []prices , int transaction , int[][]dp){
    //     if(transaction==0) return 0;
    //     if(i==prices.length) return 0;
    //     if(dp[i][transaction]!=-1) return dp[i][transaction];

    //     int skip = helper(i+1 , prices , transaction ,dp);
    //     int pick = 0;

    //     if(transaction%2==0){
    //         pick = -prices[i] + helper(i+1 , prices ,transaction-1 ,dp);
    //     }
    //     else pick = prices[i] + helper(i+1 , prices , transaction-1 ,dp);
    //     return dp[i][transaction]=Math.max(pick , skip);
    // }
    // public int maxProfit(int[] prices) {
    //     int[][]dp = new int[prices.length][5];
    //     for(int []a : dp) Arrays.fill(a ,-1);
    //     return helper(0 , prices , 4 , dp);
    // }
    public int maxProfit(int[] prices) {
        // int[][]dp = new int[prices.length+1][5];
        // int n = prices.length;
        // for(int i=n-1 ;i>=0 ;i--){
        //     for(int t=0 ;t<4 ;t++){
        //         int skip = dp[i+1][t];
        //         int pick =0;
        //         if(t%2==0) pick = -prices[i] + dp[i+1][t+1];
        //         else pick = prices[i] + dp[i+1][t+1];
        //         dp[i][t] = Math.max(pick , skip);
        //     }
        // }
        // return dp[0][0];

        int[]ahead = new int[5];
        int[]curr = new int[5];
        int n = prices.length;
        for(int i=n-1 ;i>=0 ;i--){
            for(int t=4 ;t>0 ;t--){
                int skip = ahead[t];
                int pick =0;
                if(t%2==0) pick = -prices[i] + ahead[t-1];
                else pick = prices[i] + ahead[t-1];
                curr[t]= Math.max(pick , skip);
            }
            ahead=curr;
        }
        return ahead[4];
    }
}
