import java.util.* ;
import java.io.*; 
public class Solution { 
    public static int frogJump(int n, int heights[]) {
        int []dp = new int[n];
        Arrays.fill(dp , -1);
        return helper(0 , heights , n , dp);
    }

    public static int helper(int idx , int[] heights , int n , int []dp){
        if(idx==n-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        //one step
        int oneStep = helper(idx+1 , heights , n ,dp);
        oneStep+= Math.abs(heights[idx+1] -heights[idx]);

        //two step
        int twoStep;
        if(idx+2<n){
            twoStep = helper(idx+2 , heights , n , dp);
            twoStep+= Math.abs(heights[idx+2] - heights[idx]);

        }
        else  twoStep = Integer.MAX_VALUE;

        return dp[idx] =Integer.min(oneStep , twoStep);

    }

}
