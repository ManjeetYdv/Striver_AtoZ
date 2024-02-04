import java.util.*;

public class Solution {
   
    static int []d ={0,1,-1};
    public static int helper(int i , int j1  ,int j2 , int[][]grid , int r , int c , int[][][]dp){
        if(i==r) return 0;
        if(j1<0 || j2<0 || j1>=c || j2>=c) return Integer.MIN_VALUE;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        
        int max1 =-1;
        for(int d1 : d){
            for(int d2 : d){
                if(j1==j2) {
                    max1 = Math.max(max1, helper(i + 1, j1 + d1, j2 + d2, grid, r, c ,dp));
                }
                else max1 =Math.max(max1, helper(i+1 , j1+d1 ,  j2+d2 , grid , r , c ,dp));
            }
        }
        if(j1==j2) return dp[i][j1][j2] = max1+grid[i][j1];
        return dp[i][j1][j2] = max1 + grid[i][j1] + grid[i][j2];
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][]dp = new int[r][c][c];
        for(int [][] mat:dp) 
            for(int []m :  mat)
                Arrays.fill(m , -1);
        
        return helper(0 ,0  , c-1 , grid , r, c , dp);
    }
}
