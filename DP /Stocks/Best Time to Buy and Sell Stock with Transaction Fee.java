class Solution {
    // int [][]dp;
    // public int helper(int i , int[]prices , int choice , int fee){
    //     if(i==prices.length) return 0;
    //     if(dp[i][choice]!=-1) return dp[i][choice];
    //     int skip = helper(i+1 ,prices , choice , fee);
    //     int used = 0;
    //     if(choice==1) used = prices[i] -fee + helper(i+1 , prices , 0 , fee);
    //     else used = -prices[i] + helper(i+1 , prices , 1 ,fee);

    //     return dp[i][choice]=Math.max(skip , used);
    // }

    public int maxProfit(int[] prices, int fee) {
        // dp = new int[prices.length][2];
        // for(int []a : dp)Arrays.fill(a ,-1);
        // return helper(0 , prices ,0 , fee);


        // int n = prices.length;
        // int [][]dp=new int[n+1][2];

        // for(int i=n-1 ;i>=0 ;i--){
        //     dp[i][0]= Math.max(dp[i+1][0] , prices[i]-fee + dp[i+1][1]); //0 =>selling  , 1==buy
        //     dp[i][1] = Math.max(dp[i+1][1] , -prices[i]+ dp[i+1][0]);
        // }
        // return dp[0][1];
        int n = prices.length;
        int []ahead = new int[2];
        int []curr = new int[2];

        for(int i=n-1 ;i>=0 ;i--){
            curr[0]= Math.max(ahead[0] , prices[i]-fee + ahead[1]); //0 =>selling  , 1==buy
            curr[1] = Math.max(ahead[1] , -prices[i]+ ahead[0]);
            
            ahead=curr;
        }
        return ahead[1];
    }
}
