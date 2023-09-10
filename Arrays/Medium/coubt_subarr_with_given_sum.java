class Solution {
    public int subarraySum(int[] nums, int k) {
          HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int prefix_sum=0;
        int count=0;
        for(int ele : nums){
            prefix_sum+=ele;
            int need = prefix_sum-k;
            if(map.containsKey(need)) count+=map.get(need);
            map.put(prefix_sum , map.getOrDefault(prefix_sum , 0)+1);
        }
        return count;
    }
}
