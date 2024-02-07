import java.util.*;
import java.io.*;

public class Solution {
    static int mod =(int)1e9 +7;
    public static int helper(int idx ,int []nums , int tar, int[][]dp){
        if(tar==0) return 1;
        if(idx==nums.length){
            if(tar==0) return 1;
            else return 0;
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar];
        int ways=0;
        if(tar>=nums[idx]) ways= (ways+helper(idx+1 , nums , tar-nums[idx] ,dp))%mod;
        ways =(ways+ helper(idx+1 , nums , tar,dp))%mod;
        return dp[idx][tar]= ways;
    }
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int [][]dp = new int[num.length][tar+1];
        for(int []r : dp) Arrays.fill(r ,-1);
        return helper(0 , num , tar ,dp);

    }
}
