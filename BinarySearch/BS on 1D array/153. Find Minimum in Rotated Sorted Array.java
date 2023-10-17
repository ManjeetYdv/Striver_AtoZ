class Solution {
    public int findMin(int[] nums) {
        int low=  0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            //if left sorted
            if(nums[low]<=nums[mid]) {
                min = Integer.min(min , nums[low]);
                low = mid+1;
            }
            //if right sorted
            else if (nums[mid]<=nums[high]){
                min = Integer.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}
