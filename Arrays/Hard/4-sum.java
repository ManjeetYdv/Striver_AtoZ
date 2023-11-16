class Solution {
    public void threeSum(int index , int[] nums , int need  , List<List<Integer>> res) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=index ;i<n-2 ;i++){
            if(i!=index && nums[i]==nums[i-1]) continue;
            long target =(long)need - (long)nums[i];
            if(target>Integer.MAX_VALUE || target<Integer.MIN_VALUE) continue;
            
            int j=i+1;
            int k =n-1;

            while(j<k){
                int sum = nums[j] +nums[k];

                if(sum>target) k--;
                else if(sum<target) j++;
                else{
                    //target == sum
                    List<Integer> temp = Arrays.asList(nums[index-1], nums[i] , nums[j] , nums[k]);
                    res.add(temp);

                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0 ;i<n-3 ;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            long need = (long) target - (long)nums[i];
            if(need>Integer.MAX_VALUE || need<Integer.MIN_VALUE) continue;
            threeSum(i+1, nums , (int) need  , res);
        }
        return res;

    }
}
