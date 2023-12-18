import java.util.Arrays;
public class Solution {
     
    public static int helper(int i , int []a , int n , int k , int sum , int [][]dp){
        if(sum==k) return 1;
        if(i==n) return 0;
        if(dp[sum][i]!=-1) return dp[sum][i];
        //pick
        if(sum+a[i]<=k && helper(i+1 , a, n , k ,sum+a[i] ,dp)==1) return dp[sum][i]=1;
        //not pick
        return dp[sum][i]=helper(i+1  , a, n ,k ,sum ,dp);
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        int dp[][] =new int[1001][a.length+1];
        for(int row[] : dp) Arrays.fill(row , -1);

        return helper(0 , a, n , k, 0 , dp)==1;
    }

}
