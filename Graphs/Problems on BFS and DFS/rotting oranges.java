class cell{
    int row;
    int col;
    int minutes=0;
    public cell(int row , int col ,int minutes){
        this.row=row;
        this.col=col;
        this.minutes=minutes;
    }
}
class Solution {
   int[][]directions = {{1 , 0} , {-1 , 0} ,{0 , 1}, {0 ,-1}};

    public boolean isValid(int i ,int j , int m , int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
    public int bfs(int[][]grid , Queue<cell> queue  ,int m , int n) {
      int time=0;
      while(!queue.isEmpty()){
          cell rotten = queue.poll();
          int row = rotten.row;
          int col = rotten.col;
          int t = rotten.minutes;
          time =t;
          
          for(int []d : directions){
              int nrow=row+d[0];
              int ncol=col+d[1];
              if(isValid(nrow , ncol , m ,n) && grid[nrow][ncol]==1){
                  grid[nrow][ncol]=2;
                  queue.add(new cell(nrow ,ncol , time+1));
              }
          }
      }
      return time;
    }
    public int orangesRotting(int[][] grid) {
        Queue<cell> queue = new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        
        for(int i=0 ;i<m ;i++){
            for(int j=0;j<n ;j++){
                if(grid[i][j]==2) queue.add(new cell(i , j ,0));
            }
        }
        
        int time = bfs(grid , queue ,m , n);
        for(int i=0 ;i<m ;i++){
            for(int j=0 ;j<n ;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
        
    }
}
// class Cell{
//     int i;
//     int j;
//     public Cell(){}
//     public Cell(int i ,int j){
//         this.i=i;
//         this.j=j;
//     }
// }
// class Solution {
//     int[][]directions = {{1 , 0} , {-1 , 0} ,{0 , 1}, {0 ,-1}};

//     public int bfs(int[][]grid , Queue<Cell> queue) {
//         if(queue.size()==0) return 0;
//        int time=0;

//        while(!queue.isEmpty()){
//            boolean hasNextLevel = false;
//            int size = queue.size();

//            for(int k=0 ;k<size; k++){
//                Cell cell = queue.poll();
//                int curr_i =cell.i;
//                int curr_j = cell.j;


//                for(int []d : directions){
//                    int ni =curr_i+d[0];
//                    int nj =curr_j+d[1];

//                    if(ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && grid[ni][nj]==1){
//                        hasNextLevel = true;
//                        grid[ni][nj]=2;
//                        queue.add(new Cell(ni , nj));
//                    }
//                }
//            }

//            if(hasNextLevel) time++;

//        }
//        return time;
//     }
//     public int orangesRotting(int[][] grid) {
//         int minutes=0;
//         Queue<Cell> queue = new LinkedList<>();
        
//         for(int i=0 ;i<grid.length ;i++){
//             for(int j=0 ;j<grid[0].length ;j++){
//                 if(grid[i][j]==2){
//                     queue.add(new Cell(i , j));
//                 }
//             }
//         }
        
//         minutes = bfs(grid , queue);

//         for(int i=0 ;i<grid.length ;i++){
//             for(int j=0 ;j<grid[0].length ;j++){
//                 if(grid[i][j]==1) return -1;
//             }
//         }
//         return minutes;

//     }
// }
