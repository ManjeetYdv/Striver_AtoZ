
import java.util.*;

class TUF {
    // Helper function to solve subset sum problem using dynamic programming
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If the target sum is achieved, return true
        if (target == 0)
            return true;

        // If we have considered all elements but haven't reached the target, return false
        if (ind == 0)
            return arr[0] == target;

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Store the result in the DP table and return whether either option was successful
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    // Main function to check if there exists a subset with a given target sum
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSumUtil(n - 1, k, arr, dp);
    }
}

//tabulation
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean [][]dp = new boolean[n][k+1];
       if(k==arr[0]) dp[0][k]=true;

        for(int i=0 ;i<n ;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<n ;i++){
            for(int sum=1;sum<=k ;sum++){
                //include
                if(sum-arr[i]>=0 && dp[i-1][sum-arr[i]]) dp[i][sum]=true;
                if(dp[i-1][sum]) dp[i][sum]=true;
            }
        }
        return dp[n-1][k];
    }
}

//space optimization
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean []prev = new boolean[k+1];
       if(k>=arr[0]) prev[arr[0]]=true;
       prev[0]=true;

        for(int i=1;i<n ;i++){
            boolean[]curr = new boolean[k+1];
            curr[0]=true;
            for(int sum=1;sum<=k ;sum++){
                //include
                if(sum-arr[i]>=0 && prev[sum-arr[i]])curr[sum]=true;
                if(prev[sum]) curr[sum]=true;
            }
            prev=curr;
        }
        return prev[k];
    }
}

