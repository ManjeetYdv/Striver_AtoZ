class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses ;i++) adj.add(new ArrayList<>());

        for(int []e : prerequisites) adj.get(e[1]).add(e[0]);
        int []inDegree = new int[numCourses];

        for(List<Integer> n : adj){
            for(int ele : n) inDegree[ele]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<numCourses ;i++) if(inDegree[i]==0) queue.add(i);

        int[] res = new int[numCourses];
        int idx=0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[idx++] =curr;
            
            for(int next : adj.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0) queue.add(next);
            }
        }
        
        if(idx!=numCourses) return new int[]{};
        else return  res;
    }
}
