import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
         Set<Integer> set = new HashSet<>();
        for(int ele : a) set.add(ele);

        int res=1;

        for(int i : set){

            if(!set.contains(i-1)) {
                int curr=0;
                while(set.contains(i)){
                    curr++;
                    i++;
                    res = Math.max(res, curr);
                }
            }
        }

        return res;
    }
}
