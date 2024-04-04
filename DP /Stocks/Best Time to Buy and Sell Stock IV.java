class Solution { 
   // k transaction = 2*k buy and sell
    // int[][][]dp;
    // public int helper(int i , int []prices , int k , int buy){
    //     if(k==0) return 0;
    //     if(i==prices.length) return 0;
    //     if(dp[i][k-1][buy]!=-1) return dp[i][k-1][buy];
    //     //skip
    //     int skip=helper(i+1 , prices , k , buy);
    //     //use
    //     int pick=0;
    //     if(buy==1){
    //         pick = -prices[i] + helper(i+1 , prices ,k , 0);
    //     }
    //     else pick = prices[i] + helper(i+1 , prices ,k-1 ,1);

    //     return dp[i][k-1][buy]= Math.max(skip , pick);
    // }
    // public int maxProfit(int k, int[] prices) {
    //     dp = new int[prices.length][k][2];
    //     for(int [][]arr : dp){
    //         for(int []a: arr){
    //             Arrays.fill(a ,-1);
    //         }
    //     }
    //     return helper(0 , prices , k ,1);
    // }
    public int maxProfit(int k, int[] prices) {
       int n=prices.length;
       int[][]ahead = new int[k+1][2];
       int[][]curr = new int[k+1][2];

       for(int i=n-1 ;i>=0 ;i--){
         for(int trans=1;trans<=k ;trans++){
            for(int buy=0 ;buy<=1; buy++){
                int skip = ahead[trans][buy];
                int pick =0;
                if(buy==0) pick = prices[i] + ahead[trans-1][1];
                else pick = - prices[i] + ahead[trans][0];
                curr[trans][buy]= Math.max(skip , pick);
                // curr[trans][0] = Math.max(ahead[trans][0] , prices[i] + ahead[trans-1][1]);
                // curr[trans][1] = Math.max(ahead[trans][1] , -prices[i] + ahead[trans-1][0]);
            }
         }
            ahead=curr;
    //     for(int x=0 ;x<k+1 ;x++){
    //         for(int y=0;y<=1 ;y++) ahead[x][y]=curr[x][y];
    //     }
    }
       return ahead[k][1];
}
}
