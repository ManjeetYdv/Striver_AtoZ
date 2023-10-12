import java.util.* ;
import java.io.*; 
public class Solution {

	public static int help(int i , int j  , int  m  , int n , int [][]dp){
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n ) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int down = help(i+1 , j , m , n , dp);
        int up = help(i , j+1 , m ,n , dp);
        return dp[i][j] = down+up;
    }
    public static int uniquePaths(int m, int n) {
        // Write your code here.
        int dp[][] = new int[m][n];
        for(int a[] :dp) Arrays.fill(a , -1);
        
        return help(0 , 0 , m , n , dp);
    }
}
