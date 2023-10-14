import java.util.HashMap;
public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        int prefix=0;
        int res=0;
        for(int i=0 ;i<arr.length ;i++){
            prefix += arr[i];
            if(map.containsKey(prefix)){
                res= Math.max(res , i-map.get(prefix));
            }
            else map.put(prefix , i);
        }
        return res;
    }
}
