import java.util.* ;
import java.io.*; 
public class Solution {
	static int mod =(int)1e9 +7;
	public static int helper(int i ,int n, int d , int []arr , int sum , int tsum ,int[][]dp){
		if(i==n){
			if(sum >= (tsum-sum)){
 				if(2*sum-tsum==d) return 1;
			}
			return 0;
		}
		if(dp[i][sum]!=-1) return dp[i][sum];
		 int ways=0;
		 ways = (ways+ helper(i+1 ,n , d , arr , sum+arr[i] ,tsum, dp ))%mod;
		 ways =(ways + helper(i+1 ,n , d , arr , sum , tsum ,dp))%mod;
		 return dp[i][sum] = ways;
		
	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int tsum = 0;
		for(int el :arr) tsum+=el;
		int[][]dp = new int[n][tsum+1];
		for(int []r : dp) Arrays.fill(r ,-1);

		return helper(0 ,n ,d ,arr ,0 , tsum ,dp);
	}
}
