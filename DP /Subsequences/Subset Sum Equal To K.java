import java.util.* ;
import java.io.*; 
public class Solution {
    public static int helper(int idx  , int n , int k ,int []arr ,int[][]dp){
        if(k==0) return 1;
        if(idx==n){
            if(k==0) return 1;
            else return 0;
        }
        if(dp[idx][k]!=-1) return dp[idx][k];

        if(arr[idx]<=k){
            if(helper(idx+1 , n , k-arr[idx] ,arr ,dp)==1)  return dp[idx][k] = 1;
        }
        return dp[idx][k]= helper(idx+1 , n , k, arr ,dp);
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int [][]dp = new int[n][k+1];
        for(int []r : dp) Arrays.fill(r , -1);
        return helper(0 ,n, k , arr ,dp)==1;
    }
}
