class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer , Integer> map = new HashMap<>();
        // for(int ele : nums){
        //     map.put(ele , map.getOrDefault(ele , 0)+1);
        // }
      
        // for(int key : map.keySet()){
        //     if(map.get(key)>nums.length/2) {
        //         return key;
        //     }
        // }
        // return -1;    
        int ans=0;
        int count=0;
        for(int ele : nums){
            if(count==0){
                ans = ele;
                count++;
            }
            else if(ele==ans)count++;
            else count--;
        }
        return ans;    
    
    }
    
}
