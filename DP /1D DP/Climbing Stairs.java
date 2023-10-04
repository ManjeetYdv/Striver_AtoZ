class Solution {
    // public int help(int n , int[]dp){
    //     if(n==0) return 1;
    //     if(n<0) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n] =help(n-1 , dp) + help(n-2 , dp);
    // }
    // public int climbStairs(int n) {
    // //    int[] dp = new int[n+1];
    // //    Arrays.fill(dp , -1);
    // //    return help(n , dp);
    // }

    public int climbStairs(int n) {
    if(n<=1)return n;
        int prev1 =1;
        int prev2=1;
        
        for(int i=2 ;i<=n ;i++){
            int temp = prev1;
            prev1 =prev1+ prev2;
            prev2 = temp;
        }
        return prev1;
    }
}
