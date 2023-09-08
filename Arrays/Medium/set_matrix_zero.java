class Solution {

     public void setZeroes(int[][] matrix) {

         //brute force
        // int []row = new int[matrix.length];
        // int []col = new int[matrix[0].length];
        
        // for(int i=0 ;i<matrix.length ;i++){
        //     for(int j=0 ;j<matrix[0].length ;j++){
        //         if(matrix[i][j]==0){
        //             row[i]=1;
        //             col[j]=1;
        //         }
        //     }
        // }
        
        // for(int i=0 ;i<matrix.length ;i++){
        //     if(row[i]==1){
        //         for(int j=0 ;j<matrix[0].length ;j++){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
        
        // for(int i=0 ;i<matrix[0].length ;i++){
        //     if(col[i]==1){
        //         for(int j=0 ;j<matrix.length ;j++){
        //             matrix[j][i]=0;
        //         }
        //     }
        // }

          
       int row=1;
       int m=matrix.length;
       int n = matrix[0].length;
       
       for(int i=0 ;i<m ;i++){
           for(int j=0;j<n ;j++){
               if(matrix[i][j]==0){
                   if(i==0) row=0;
                   else {
                       matrix[0][j]=0;
                       matrix[i][0]=0;
                   }
               }
           }
       }
       
       for(int i=1 ;i<m;i++){
           for(int j=1 ;j<n ;j++){
               if(matrix[0][j]==0 || matrix[i][0]==0) matrix[i][j]=0;
           }
       }
       
       if(matrix[0][0]==0){
           for(int i=0 ;i<m ;i++){
               matrix[i][0] =0;
           }
       }

       if(row==0){
           for(int i=0 ;i<n ;i++){
               matrix[0][i]=0;
           }
       }
       
     }
 
}
