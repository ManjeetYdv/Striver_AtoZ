import java.util.* ;
import java.io.*; 
public class Solution {
	static int[][][]dp;
	public static int helper(int r  , int c1 , int c2 , int n , int c , int[][]grid){
		if(r==n) return 0;
		if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];

		int max=-1;
		for(int i=-1 ;i<=1 ;i++){
			for(int j=-1;j<=1;j++){
				if(c1+i<0 || c2+j<0 || c1+i>=c || c2+j>=c) continue;
				max = Math.max(max , helper(r+1 , c1+i , c2+j , n , c ,grid));
			}
		}
		if(c1==c2) return dp[r][c1][c2]=grid[r][c1] + max;
		else return dp[r][c1][c2]= grid[r][c1]+grid[r][c2]+max;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		// dp = new int[r][c][c];
		// for(int [][]mat : dp){
		// 	for(int []m:mat){
		// 		Arrays.fill(m ,-1);
		// 	}
		// }
		// return helper(0 , 0 , c-1 ,r ,c, grid);
		int[][][]dp = new int[r][c][c];
        for(int j1=0 ;j1<c ;j1++){
            for(int j2=0 ;j2<c ;j2++){
                if(j1==j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }
        
        for(int i=r-2 ;i>=0 ;i--){
            for(int j1=0 ;j1<c ;j1++){
                for(int j2=0 ;j2<c ;j2++) { 
                    int max=-1;
                    for(int k1=-1;k1<=1; k1++){
                        for(int k2=-1;k2<=1 ;k2++){
                            if(j1+k1<0 || j2+k2<0 || j1+k1>=c || j2+k2>=c) continue;
                            max= Math.max(max , dp[i+1][j1+k1][j2+k2]);
                        }
                    }
                    if(j1==j2) dp[i][j1][j2] = grid[i][j1] + max;
                    else dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
                }
            }
        }
        return dp[0][0][c-1];

	}
}
