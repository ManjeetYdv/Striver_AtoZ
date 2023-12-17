public static void helper(int i , int j , int[][]m , int n , StringBuilder path , ArrayList<String> res){
        if(i<0 || j<0 || i>=n || j>=n || m[i][j]==0) return;
        if(i==n-1 && j==n-1){
            res.add(path.toString());
            return;
        }

        m[i][j]=0; //to make sure it's not visited again

        //move UP(U)
        path.append('U');
        helper(i-1 , j, m , n,path , res);

        //moveing down(D)
        path.setCharAt(path.length()-1 , 'D');
        helper(i+1 ,j ,m,n , path , res);

        //moving left (L)
        path.setCharAt(path.length()-1 ,'L' );
        helper(i  , j-1, m ,n ,path , res);

        //moving right(R)
        path.setCharAt(path.length()-1 ,'R');
        helper(i , j+1 , m , n , path ,res);

        path.setLength(path.length()-1);
        m[i][j]=1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here

        ArrayList<String> res = new ArrayList<>();
        if(m[n-1][n-1]==0){
            res.add("-1");
            return res;
        }
        helper(0 ,0 ,m ,n ,new StringBuilder() , res);
        return res;
    }
