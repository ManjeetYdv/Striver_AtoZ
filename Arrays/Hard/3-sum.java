class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;
        
        // for(int i=0 ;i<n-2 ;i++){
        //     for(int j=i+1 ;j<n-1; j++){
        //         for(int k =j+1 ; k<n ;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k]);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> res = new ArrayList<>();
        // for(List<Integer> list : set){
        //     res.add(list);
        // }
        // return res;

        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;
        // HashSet<Integer> hash = new HashSet<>();

        // for(int i=0 ;i<n ;i++){
        //     for(int j=i+1 ;j<n ;j++){
        //         int target = -(nums[i]+nums[j]);

        //         if(hash.contains(target)){
        //             List<Integer> temp = Arrays.asList(nums[i] , target , nums[j]);
        //             Collections.sort(temp);
        //             set.add(temp);
        //         }
        //         hash.add(nums[j]);
        //     }
        //     hash.clear();
        // }
            List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i=0 ;i<n-2 ;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            
            int j=i+1;
            int k =n-1;
            
            while(j<k){
                int sum = nums[j] +nums[k];
                
                if(sum>target) k--;
                else if(sum<target) j++;
                else{
                    //target == sum
                    List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k]);
                    res.add(temp);
                    
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return res;
        
    }
}
