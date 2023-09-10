import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        int right_max = Integer.MIN_VALUE;
        
        for(int i=a.length-1 ;i>=0 ;i--){
            if(a[i]>right_max){
                right_max = a[i];
                res.add(a[i]);
            }
        }
        return res;
    }
}
