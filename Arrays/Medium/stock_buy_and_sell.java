class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];  //min pirce till day
        int profit =0;
        
        for(int i=1 ;i<prices.length;i++){
            profit = Integer.max(profit , prices[i]-min);
            min = Integer.min(min , prices[i]);
        }
        return profit;
    }
}
