public class Solution {
    public static void rev(int idx ,int n  , int[]arr){
        if(idx>=n/2) return;
        int temp = arr[n-idx-1];
        arr[n-idx-1] = arr[idx];
        arr[idx] = temp;
        rev(idx+1 , n , arr);
    }
    public static int[] reverseArray(int n, int []nums) {
        // Write your code here.
        rev(0 , n, nums);
        return nums;

    }
}
