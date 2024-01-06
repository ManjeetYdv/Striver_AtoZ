class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge : prerequisites) adj.get(edge[1]).add(edge[0]);

        int[] inDegree = new int[numCourses];
        for(List<Integer> list : adj){
            for(int node : list){
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<numCourses ;i++){
            if(inDegree[i]==0) queue.add(i);
        }

        int cnt=0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            cnt++;

            for(int node : adj.get(curr)){
                inDegree[node]--;
                if(inDegree[node]==0) queue.add(node);
            }
        }
        return cnt==numCourses;
    }
}
