import java.util.HashMap;
public class Solution {
    public static int[] getFrequencies(int []v) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : v) map.put(ele, map.getOrDefault(ele, 0) + 1);

        int minCount = v.length + 1;
        int maxCount = 0;
        int maxEle = Integer.MAX_VALUE;
        int minELe = Integer.MAX_VALUE;

        for (int n : map.keySet()) {
            int count = map.get(n);

            if (count <= minCount) {
                if(count==minCount) minELe = Integer.min(minELe , n);
                else minELe =n;
                minCount = count;
            }
            if (count >= maxCount) {
                if(count==maxCount) maxEle = Integer.min(maxEle , n);
                else maxEle =n;
                maxCount = count;

            }
        }
        return new int[]{maxEle , minELe};
    }
}
