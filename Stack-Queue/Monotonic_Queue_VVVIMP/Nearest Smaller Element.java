public class Solution {
    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int[]prev= new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int i=0;i<n ;i++){
            while(!stack.isEmpty() && A[stack.peek()]>=A[i]){
                stack.pop();
            }
            prev[i]=stack.isEmpty() ? -1 :A[stack.peek()];
            stack.push(i);
        }
        return prev;
    }
}
