class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i] , i);
        }

        int[]next= new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0 ;i--){
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                stack.pop();
            }
            
            if(map.containsKey(nums2[i])){
            int idx=map.get(nums2[i]);
            next[idx] = stack.isEmpty() ? -1 : nums2[stack.peek()];
            }
            stack.push(i);
        }
        return next;
    }
}
