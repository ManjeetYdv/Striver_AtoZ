class Solution {
   
    public int maxProfit(int[] prices) {
        // dp = new int[prices.length][2];
        // for(int []a : dp) Arrays.fill(a ,-1);

        // return helper(0 , prices , 1);
        int n=prices.length;
        int[]ahead = new int[2];
        int[]curr = new int[2];

        for(int i=n-1; i>=0 ;i--){
             for(int buy=0 ; buy<=1 ;buy++){
                //skip
                int skip = ahead[buy];
                int pick=0;
                if(buy==0) pick = prices[i] + ahead[1];
                else pick = - prices[i] + ahead[0];
                curr[buy] = Math.max(skip ,pick);
            }
                ahead=curr;
        }
        return ahead[1];
    }
}
