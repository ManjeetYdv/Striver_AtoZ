//memoization
import java.util.* ;
import java.io.*; 
public class Solution { 
    static int[]dp;
    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp ,-1);
        return helper(n-1 ,heights);
    }
    public static int helper(int idx , int[]heights){
        if(idx==0){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int minStep=Math.abs(heights[idx]-heights[idx-1]) +  helper(idx-1 , heights);
        if(idx-2>=0) minStep = Math.min(minStep , Math.abs(heights[idx]-heights[idx-2])+ helper(idx-2 ,heights));

        return dp[idx]= minStep;
    }
    
}


//tabulation
import java.util.* ;
import java.io.*; 
public class Solution { 
    
    public static int frogJump(int n, int heights[]) {
        int[]dp = new int[n];
        
        for(int i=1; i<n;i++){
            int jumpOne=dp[i-1]+ Math.abs(heights[i]-heights[i-1]);
            int jumpTwo = (int)1e9;
            if(i>1) jumpTwo =dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            dp[i] = Math.min(jumpOne , jumpTwo);
        }
        return dp[n-1];
    }
    
    
}
