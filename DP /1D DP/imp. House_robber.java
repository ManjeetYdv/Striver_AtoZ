class Solution {
    //recursion + memoization
   // public int help(int idx , int[]nums , int n  , int[]dp){
    //     if(idx>=n) return 0;
    //     if(dp[idx]!=-1) return dp[idx];
    //     //pick
    //     int pick = nums[idx] + help(idx+2 , nums , n , dp);
    //     //not pick
    //     int skip = help(idx+1 , nums , n , dp);
    //     return dp[idx] = Integer.max(pick , skip);
    // }
    // public int rob(int []nums) {
    //     int n = nums.length;
    //     int []dp = new int[n];
    //     Arrays.fill(dp , -1);
    //     return help(0 , nums , n , dp);
    // }


    //tabulation
    // public int rob(int []nums) {
    //     int n = nums.length;
    //     int []dp = new int[n];
    //     dp[0] = nums[0];

    //     for(int i=1 ;i<n ;i++){
    //         int pick = nums[i];
    //         if(i>1) pick +=dp[i-2];

    //         int skip = dp[i-1];
    //         dp[i] = Integer.max(pick , skip);
    //     }
    //     return dp[n-1];
    // }

    //space optimzation
    public int rob(int []nums) {
        int prev2=0;
        int prev1=nums[0];
        int n = nums.length;

        for(int i=1 ;i<n ;i++){
            int temp = prev1;
            prev1 = Integer.max(prev1 , prev2+ nums[i]);
            prev2 = temp;
        }
        
        return prev1;
    }
} 
