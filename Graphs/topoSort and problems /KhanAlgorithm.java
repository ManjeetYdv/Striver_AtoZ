 int []inDegree = new int[V];
        for(ArrayList<Integer> list : adj){
            for(int node : list){
                inDegree[node]++;
            }
        }

        //no need of vis because once a node has inDegree 0 it won't be visited again
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ;i<V ;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int[]res = new int[V];
        int idx=0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            res[idx++]=node;

            for(int neighbour: adj.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return res;
