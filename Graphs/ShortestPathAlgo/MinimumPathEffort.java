class tuple{
    int i;
    int j;
    int max;
    tuple(int i , int j , int max){
        this.i=i;
        this.j=j;
        this.max=max;
    }
}
class Solution {
    public boolean isValid(int i ,int j, int m , int n){
        return i>=0 && j>=0 && i<m && j<n;
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n= heights[0].length;
        int[][]dis = new int[m][n];
        int [][]direction ={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[]r : dis) Arrays.fill(r , Integer.MAX_VALUE);

        PriorityQueue<tuple>pq = new PriorityQueue<>((a,b)->a.max-b.max);
        pq.add(new tuple(0 , 0 , 0));
        dis[0][0]=0;
        
        while(!pq.isEmpty()){
            tuple t = pq.poll();
            int i=t.i;
            int j=t.j;
            int d = t.max;
            if(i==m-1 && j==n-1) return d;
            
            for(int[] dir : direction ){
                int nrow = i+dir[0];
                int ncol = j+dir[1];
                
                if(isValid(nrow , ncol , m , n)){
                    int absDiff = Math.abs(heights[i][j]-heights[nrow][ncol]);
                    int max = Math.max(absDiff , d);
                    
                    if(max<dis[nrow][ncol]){
                        dis[nrow][ncol]=max;
                        pq.add(new tuple(nrow , ncol , max));
                    }
                }
            }
        }
        return -1;
    }
}
