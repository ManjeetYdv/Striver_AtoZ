class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n=nums.length;

        for(int i=n-1 ;i>=0 ;i--){
            stack.push(i);
        }

        int[]nextG = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            nextG[i]= stack.isEmpty() ? -1 :nums[stack.peek()];
            stack.push(i);
        }
        return nextG;
    }
}
