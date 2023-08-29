public class Solution {
    public static int[] countFrequency(int n, int x, int []nums){
        // Write your code here.
        int[]arr = new int[n];
        for(int ele : nums){
            if(ele<=n) arr[ele-1]++;
        }
        return arr;
    }
}
