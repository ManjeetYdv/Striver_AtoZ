class Cell{
    int i;
    int j;
    public Cell(){}
    public Cell(int i ,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    int[][]directions = {{1 , 0} , {-1 , 0} ,{0 , 1}, {0 ,-1}};

    public int bfs(int[][]grid , Queue<Cell> queue) {
        if(queue.size()==0) return 0;
       int time=0;

       while(!queue.isEmpty()){
           boolean hasNextLevel = false;
           int size = queue.size();

           for(int k=0 ;k<size; k++){
               Cell cell = queue.poll();
               int curr_i =cell.i;
               int curr_j = cell.j;


               for(int []d : directions){
                   int ni =curr_i+d[0];
                   int nj =curr_j+d[1];

                   if(ni>=0 && nj>=0 && ni<grid.length && nj<grid[0].length && grid[ni][nj]==1){
                       hasNextLevel = true;
                       grid[ni][nj]=2;
                       queue.add(new Cell(ni , nj));
                   }
               }
           }

           if(hasNextLevel) time++;

       }
       return time;
    }
    public int orangesRotting(int[][] grid) {
        int minutes=0;
        Queue<Cell> queue = new LinkedList<>();
        
        for(int i=0 ;i<grid.length ;i++){
            for(int j=0 ;j<grid[0].length ;j++){
                if(grid[i][j]==2){
                    queue.add(new Cell(i , j));
                }
            }
        }
        
        minutes = bfs(grid , queue);

        for(int i=0 ;i<grid.length ;i++){
            for(int j=0 ;j<grid[0].length ;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return minutes;

    }
}
