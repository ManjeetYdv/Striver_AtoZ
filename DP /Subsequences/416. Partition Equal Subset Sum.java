class Solution {
    public int helper(int idx , int sum , int totalSum ,int []nums , int[][]dp){
        if(sum==totalSum/2) return 1;
        if(idx==nums.length ) {
            if(sum==totalSum/2) return 1;
            else return 0;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum];
        if(sum+nums[idx] <= totalSum/2){
            if(helper(idx+1 , sum+nums[idx] , totalSum , nums , dp)==1) return dp[idx][sum]=1;
        }
        return dp[idx][sum]= helper(idx+1 , sum , totalSum ,nums ,dp);
    }
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int ele : nums) totalSum+=ele;
        if(totalSum%2!=0) return false;
        int[][]dp = new int[nums.length][totalSum/2+1];
        for(int []r :dp) Arrays.fill(r , -1);
        return helper(0 ,0 ,totalSum , nums ,dp)==1;
    }
}
