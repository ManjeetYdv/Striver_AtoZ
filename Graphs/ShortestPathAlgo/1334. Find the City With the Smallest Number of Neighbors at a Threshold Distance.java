class Solution {
     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][]mat = new int[n][n];
       for(int []m : mat) {
           Arrays.fill(m , (int)1e9);
       }

       for(int []e:edges){
           mat[e[0]][e[1]] = e[2];
           mat[e[1]][e[0]] = e[2];
       }
       for(int i=0 ;i<n ;i++) mat[i][i]=0;

       for(int k=0 ;k<n ;k++){
           for(int i=0 ;i<n ;i++){
               for(int j=0;j<n ;j++){
                   int d = mat[i][k] + mat[k][j];
                   if(d<=distanceThreshold && d<mat[i][j]){
                       mat[i][j]=d;
                   }
               }
           }
       }
       int min=n;
       int ans=-1;
       for(int i=0 ;i<n ;i++){
           int temp=0;
           for(int j=0 ;j<n;j++){
               if(mat[i][j]<= distanceThreshold)temp++;
           }
           if(temp<=min){
               min=temp;
               ans=i;
           }
       }
        return ans;
    }
}
