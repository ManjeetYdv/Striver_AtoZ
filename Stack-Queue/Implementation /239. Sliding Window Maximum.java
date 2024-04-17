class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int i=0;
        int j=0;
        int n=nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[]res =  new int[n-k+1];
        int idx=0;
        while(j<n){
            //calculations
           // while(!deque.isEmpty() && deque.peek()<=nums[j]) deque.poll();
            while(!deque.isEmpty() && nums[deque.getLast()]<=nums[j]) deque.pollLast();
            deque.addLast(j);

            if(j-i+1<k) j++;
            else if(j-i+1==k){
                res[idx++]= nums[deque.getFirst()];
                if(deque.getFirst()==i) deque.removeFirst();
                i++;
                j++;
            } 
        }
        return res;
    }
}
