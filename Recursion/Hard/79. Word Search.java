class Solution {
         int[][] directions ={{-1 , 0} , {1 ,0} ,{0 , -1} , {0 , 1}};
    
    public  boolean helper(int index , String word , int i , int j, char[][] board){
        if(index==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(index)!=board[i][j]) return false;
        
        for(int [] d : directions){
            char temp = board[i][j]; //used insted of vsisited to save space
            board[i][j]='.';
            if(helper(index+1 , word , i+d[0] , j+d[1] , board)) return true;
            board[i][j]=temp;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0 ;i<board.length ;i++){
            for(int j=0 ;j<board[0].length ;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(0 , word , i ,j ,board)) return true; 
                }
            }
        }
        return false;
    }

}
