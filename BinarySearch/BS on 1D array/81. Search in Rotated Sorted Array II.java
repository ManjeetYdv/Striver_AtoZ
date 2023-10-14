class Solution {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid]==target) return true;
            
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){ //case when cant identify sorted part
                low= low+1;
                high= high-1;
            }
            else if(nums[low]<=nums[mid]){  //if left part is sorted
                if(nums[low]<=target && target<=nums[mid]) high = mid-1; //checking if element exist in left if left is sorted
                else low = mid+1;
            }
            else{ //if right subarr is sorted
                if(nums[mid]<=target && target<=nums[high]) low = mid+1; //checking if element exist in right if right is sorted
                else high = mid-1;
            }
        }
        return false;
      
    }
}
