class Solution {
    public void helper(int currCol , char [][]board ,int n , List<List<String>> res){
        if(currCol==n){
            //board to list of string
            List<String> b =boardToString(board);
            res.add(b);
            return;
        }
        
        for(int i=0 ;i<n ;i++){
            if(check(i , currCol , board)){
                board[i][currCol]='Q';
                helper(currCol+1 , board ,n , res);
                board[i][currCol]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];

        for(char row[] : board){
            Arrays.fill(row , '.');
        }
        List<List<String>> res= new ArrayList<>();
        //function
        helper(0 , board , n , res);
        return res;
    }
    public boolean check(int i , int j , char board[][]){
        int row = i;
        int col =j;

        //cheking left
        while(col>=0){
            if(board[i][col--]=='Q') return false;
        }
        //diagonally down
        col=j;
        while(row<board.length && col>=0){
            if(board[row++][col--]=='Q') return false;
        }
        //diagonally up
        row=i;
        col=j;
        while(row>=0 && col>=0){
            if(board[row--][col--]=='Q') return false;
        }

        return true;
    }

    public List<String> boardToString(char [][]board){
        List<String> list = new ArrayList<>();
        
        for(char row[] : board){
            list.add(new String(row));
        }
        return list;
    }
}
