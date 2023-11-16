import java.util.HashMap;
public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = arr.length;
        map.put(0 , -1);
        int max =0;
        int prefix_sum=0;
        for(int i=0 ;i<n ;i++){
            prefix_sum+=arr[i];
            if(map.containsKey(prefix_sum)){
                max = Integer.max(max , i-map.get(prefix_sum));
            }
            else map.put(prefix_sum , i);
        }
        return max;
    }
}
