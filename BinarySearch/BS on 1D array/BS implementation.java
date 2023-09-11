class Solution {
    //recursive
    int binaryS(int low , int high , int[]arr , int target){
        if(low>high) return -1;
        
        int mid = (low+high)/2;
        if(arr[mid]==target) return mid;
        if(arr[mid]< target) return binaryS(mid+1 , high , arr , target);
        else return binaryS(low , mid-1 , arr , target);
    }
    public int search(int[] nums, int target) {
        return binaryS(0 , nums.length-1 , nums , target);
    }


    //Iterative
    // public int search(int[] nums, int target) {
    //     int low = 0;
    //     int high = nums.length-1;

    //     while(low<=high){
    //         int mid = low + (high-low)/2;
    //         if(nums[mid]==target) return mid;
    //         else if(nums[mid]<target)  low = mid+1;
    //         else high = mid-1;
    //     }
    //     return -1;
    // }
}
