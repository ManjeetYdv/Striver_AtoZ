class Solution {
    //first ==1==robbed first house
    // public int helper(int i , int []nums  , int first , int[][]dp){
    //     if(i>=nums.length) return 0;
    //     if(first==1 && i==nums.length-1) return 0;
    //     if(dp[i][first]!=-1) return dp[i][first];

    //     int max = -1;
    //     if(i==0) max = Math.max(max , nums[i] + helper(i+2 , nums , 1 ,dp));
    //     else max = Math.max(max ,nums[i] + helper(i+2, nums , first ,dp));

    //     max=  Math.max(max , helper(i+1, nums ,first,dp));
    //     return dp[i][first]=max;
    // }
    // public int rob(int[] nums) {
    //     int[][]dp = new int[nums.length][2];
    //     for(int []r : dp) Arrays.fill(r , -1);
    //     return helper(0 , nums ,0 ,dp);
    // }

    public int helper(int s , int e ,int[] nums) {
        int prev1 = nums[s];
        int prev2 = 0;

        for(int i=s+1; i<e ;i++){
            int pick = nums[i]+prev2;
            int temp = prev1;
            prev1 = Math.max(prev1 , pick);
            prev2=temp;
        }
        return Math.max(prev1, prev2);
    }
    public int rob(int[] nums) {
       if(nums.length==1) return nums[0];
        
       int pick1 = helper(0 , nums.length-1 , nums);
       int skip1 = helper(1 , nums.length , nums);
       return Math.max(pick1 ,skip1);
    }
}
