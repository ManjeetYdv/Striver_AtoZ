import java.util.Arrays;

public class Solution {
    // static int[][]dp;
    // public static int helper(int n , int [][]points ,int prev){
    //     if(dp[n][prev]!=-1) return dp[n][prev];
    //     if(n==0){
    //         int max=-1;
    //         for(int i=0 ;i<3 ;i++){
    //           if(i!=prev)max = Math.max(points[0][i] ,max);
    //         }
    //         return max;
    //     }

    //     int res=-1;
    //     for(int i=0 ;i<3 ;i++){
    //         if(i!=prev) res=Math.max(res , points[n][i]+helper(n-1 , points ,i));
    //     }
    //     return dp[n][prev]= res;
    // }
    // public static int ninjaTraining(int n, int points[][]){
    //     dp = new int[n][4];
    //     for(int []m:dp) Arrays.fill(m ,-1);
    //     return helper(n-1 , points ,3);
    // }       
    public static int ninjaTraining(int n, int points[][]){
        int[][]dp = new int[n][3];
        for(int task=0; task<3 ;task++) dp[0][task]=points[0][task];

        for(int i=1;i<n ;i++){
            for(int task=0; task<3; task++){
                int maxTask=-1;
                for(int j=0;j<3 ;j++){
                    if(j!=task) maxTask = Math.max(maxTask , dp[i-1][j]);
                }
                dp[i][task] = points[i][task] + maxTask;
            }
        }
        return Math.max(dp[n-1][0] , Math.max(dp[n-1][1] , dp[n-1][2]));
    }
}
