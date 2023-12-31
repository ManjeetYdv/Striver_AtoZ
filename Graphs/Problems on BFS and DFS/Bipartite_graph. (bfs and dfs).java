// class NodeColor{
//     int node;
//     int color;

//     public NodeColor(){}
//     public NodeColor(int node , int color){
//         this.node=node;
//         this.color=color;
//     }
// }
class Solution {
    public boolean dfs(int node, int currColor, int[][] graph, int[] color) {
        color[node]= currColor; 
        int newColor = (currColor+1)%2; //new color is for adjacent nodes
        for (int i = 0; i < graph[node].length; i++) {
            if(color[graph[node][i]] == -1) {
                if (!dfs(graph[node][i], newColor, graph, color)) return false;
            } 
            else if (color[graph[node][i]] != newColor) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length]; //working as visited also
        Arrays.fill(color , -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) if (!dfs(i  , 0 , graph ,color)) return false;
        }
        return true;
           
    }

    //bfs
    // public boolean bfs(int node , int [][]graph , int []color){
    //     Queue<NodeColor>queue = new LinkedList<>();
    //     queue.add(new NodeColor(node ,0));
    //     color[node]=0;
    //     while(!queue.isEmpty()){
    //         NodeColor n = queue.poll();
    //         int currNode = n.node;
    //         int currColor =n.color;
    //         int newColor =(currColor+1)%2;
            
    //         for(int i=0 ;i<graph[currNode].length ;i++){
    //             if(color[graph[currNode][i]]==-1){
    //                 color[graph[currNode][i]] = newColor;
    //                 queue.add(new NodeColor( graph[currNode][i] ,newColor));
    //             }
    //             else if(color[graph[currNode][i]]==currColor) return false;
    //         }
            
    //     }
    //     return true;
    // }
    // public boolean isBipartite(int [][]graph){
    //     int [] color = new int[graph.length];
    //     Arrays.fill(color , -1);
        
    //     for(int i=0 ;i<graph.length ;i++){
    //         if(color[i]==-1) if(!bfs(i , graph , color)) return false;
    //     }
    //     return true;
        
    // }
}
