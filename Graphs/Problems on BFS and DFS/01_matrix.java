package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//class Pair{
//    int i;
//    int j;
//    public Pair(){}
//    public Pair(int i , int j){
//        this.i=i;
//        this.j=j;
//    }
//}

class Pair{
    int row;
    int col;
    int d;

    public Pair(){}
    public Pair(int row , int col , int d){
        this.row =row;
        this.col =col;
        this.d =d;
    }
}
public class _01_matrix {
    public boolean isValid(int i , int j , int m , int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
//    public int findNearestZero(int i ,int j ,int[][]matrix , int m , int n , int [][]res  , int[][]vis){
//        int d=0;
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(i,j));
//        int [][] directions={{1,0},{-1,0},{0,1},{0,-1}};
//        vis[i][j] =1;
//        while(!queue.isEmpty()){
//            d++;
//            int size = queue.size();
//
//            for(int k=0 ;k<size ;k++){
//                Pair pair = queue.poll();
//                int row = pair.i;
//                int col = pair.j;
//
//                for(int []dir : directions){
//                    int nrow = row+dir[0];
//                    int ncol = col+dir[1];
//
//                    if(isValid(nrow ,ncol , m , n)){
//                        if(matrix[nrow][ncol]==0) return d;
//                        else if(res[nrow][ncol]!=-1) return d+res[nrow][ncol];
//                        else if(vis[nrow][ncol]==0){
//                            vis[nrow][ncol]=1;
//                            queue.add(new Pair(nrow , ncol));
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }
  //  public int[][] updateMatrix(int[][] mat) {
//        int m = mat.length;
//        int n = mat[0].length;
//        int[][]res = new int[m][n];
//        int [][]vis = new int[m][n];
//        for(int []row : res) Arrays.fill(row , -1);
//
//        for(int i=0 ;i<m ;i++){
//            for(int j=0 ;j<n ;j++){
//                if(mat[i][j]!=0){
//                    mat[i][j] = findNearestZero(i ,j  , mat , m , n , res , vis);
//                    for(int []row : vis) Arrays.fill(row , 0);
//                }
//                else mat[i][j]=0;
//            }
//        }
//        return mat;
    //}
    public int[][] updateMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int [][]res = new int[m][n];
        boolean [][]vis = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0 ;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                if(mat[i][j]==1){
                    queue.add(new Pair(i , j ,0));
                }
            }
        }

        int [][]directions = {{1,0} ,{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int d = pair.d;

            res[row][col]=d;
            for(int []dir : directions){
                int nrow=row+dir[0];
                int ncol=col+dir[1];

                if(isValid(nrow ,ncol ,m, n ) && !vis[nrow][ncol] && mat[nrow][ncol]==0){
                    vis[nrow][ncol]=true;
                    queue.add(new Pair(nrow , ncol , d+1));
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

    }
}
