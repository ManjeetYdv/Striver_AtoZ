class Cell{
    int i;
    int j;

    public Cell(){}
    public Cell(int i , int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    // int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    // public void dfs(int i , int j , int [][]flood , int[][]image , int prevColor , int color){
    //     //if out of bound || cell is not colored as main cell || flood cell is already colored return
    //     if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=prevColor || flood[i][j]==color) return;

    //     flood[i][j]=color;
    //     for(int []d : directions){
    //         dfs(i+d[0] , j+d[1] , flood , image , prevColor , color);
    //     }

    // }
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     int m = image.length;
    //     int n = image[0].length;

    //     int [][]flood = new int[m][n];
    //     for(int i=0 ;i<m ;i++){
    //         for(int j=0 ;j<n ;j++){
    //             flood[i][j]=image[i][j];
    //         }
    //     }

    //     dfs(sr , sc , flood , image , image[sr][sc] , color );
    //     return flood;
    // }
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
    
        int [][]flood = new int[m][n];
        int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0 ;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                flood[i][j]=image[i][j];
            }
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(sr , sc));
        int og = image[sr][sc];

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            int i=cell.i;
            int j=cell.j;
            flood[i][j]=color;

            for(int []d : directions){
                int next_i =i+d[0];
                int next_j =j+d[1];
                if(!isValidIdx(next_i ,next_j , m , n)) continue;
                if(flood[next_i][next_j]!=color && image[next_i][next_j]==og){
                    queue.add(new Cell(next_i , next_j));
                }
            }
        }
        return flood;
    }

    public boolean isValidIdx(int i , int j  , int m , int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
