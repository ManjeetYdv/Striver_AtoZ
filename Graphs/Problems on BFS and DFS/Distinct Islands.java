import java.util.*;
class Cell{
    int i;
    int j;

    public Cell(){}
    public Cell(int i , int j){
        this.i=i;
        this.j=j;
    }
}

public class Solution 
{
	static int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public static int distinctIsland(int [][] arr, int n, int m)
    {
        Set<List<List<Integer>>> set = new HashSet<>();
        int [][]vis = new int[n][m];
        for(int i=0 ;i<n ;i++){
            for(int j=0 ;j<m ;j++){
                if(arr[i][j]==1 && vis[i][j]==0){
                    List<List<Integer>> path = island(i ,j ,arr , n, m,  vis);
                    set.add(path);
                }
            }
        }
		
        return set.size();
        //write your code here
    }
    public static List<List<Integer>> island(int i , int j , int[][] arr , int n , int m , int[][]vis){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = Arrays.asList(0 ,0);
        list.add(temp);
        
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(i ,j));
        vis[i][j]=1;

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int row = cell.i;
            int col = cell.j;

            for(int []move : directions){
                int nrow = row+move[0];
                int ncol = col+move[1];
                if(isValid(nrow ,ncol ,n ,m ) && vis[nrow][ncol]==0 && arr[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    queue.add(new Cell(nrow ,ncol));
                    List<Integer> t = Arrays.asList(nrow-i , ncol-j);
					list.add(t);
                }
            }
        }
        return list;
    }
    public static boolean isValid(int i ,int j , int n ,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}
