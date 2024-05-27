class Solution {
    public int atMost(int []nums , int k){
        int i=0;
        int j=0;
        int n=nums.length;
        int res=0;
        HashMap<Integer , Integer> map = new HashMap<>();
        while(j<n){
            map.put(nums[j] , map.getOrDefault(nums[j],0)+1);
            while(i<=j && map.size()>k){
                map.put(nums[i] ,map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            res+=j-i+1;
            j++;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int x =atMost(nums ,k);
        int y =atMost(nums ,k-1);
        return x-y;
    }
}
