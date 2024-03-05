import java.util.Arrays;
public class Solution {
    // public static int minimizeCost(int n, int k, int []height){
    //     // Write your code here.
    //     return helper(0 , k , height , n);
    // }
    // public static int helper(int idx , int k , int[]height , int n ){
    //     if(idx==n-1) return 0;
        
    //     int optimal = Integer.MAX_VALUE;
    //     for(int i=1 ;i<=k ;i++){
    //         if(idx+i<n){
    //             int temp = helper(idx+i , k , height , n);
    //             optimal = Math.min( optimal , temp + Math.abs(height[idx+i]-height[idx]));
    //         }
    //     }
    //     return optimal;
    // }
    public static int minimizeCost(int n, int k, int []height){
        int []dp = new int[n];
        Arrays.fill(dp , -1);
        // Write your code here.
        return helper(0 , k , height , n ,dp);
    }
    public static int helper(int idx , int k , int[]height , int n  , int[]dp){
        if(idx==n-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        
        int optimal = Integer.MAX_VALUE;
        for(int i=1 ;i<=k ;i++){
            if(idx+i<n){
                int temp = helper(idx+i , k , height , n , dp);
                optimal = Math.min( optimal , temp + Math.abs(height[idx+i]-height[idx]));
            }
        }
        return dp[idx] = optimal;
    }
}

//tabulation
import java.util.Arrays;
public class Solution {
     
    public static int minimizeCost(int n, int k, int []height){
   
        int[]dp = new int[n];
        for(int i=1;i<n;i++){
            int min =(int)1e9;
            for(int j=1;j<=k;j++){
                if(i-j<0) break;
                else min = Math.min(min, Math.abs(height[i]-height[i-j])+ dp[i-j]);
            }
            dp[i]=min; 
        }
        return dp[n-1];

    }
 
    
}
