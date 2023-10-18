class Solution {
    public int findPeakElement(int[] nums) {
        // if(nums.length==1) return 0;
        
        // for(int i=0 ;i<nums.length ;i++){
        //     if(i==0){
        //         if(nums[i]>nums[i+1]) return i;
        //     }
        //     else if(i==nums.length-1){
        //         if(nums[i]>nums[i-1]) return i;
        //     }
        //     else{
        //         if(nums[i-1]<nums[i] && nums[i]>nums[i+1]) return i;
        //     }
        // }
        // return 0;

        int n = nums.length;
        if(n==1) return 0;
        
        //checking these cases to reduce multiple if else in while 
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1;
        int high = n-2;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;

            //since all elements to the left of peak element will be sorted
            //check whether you are in sorted or non sorted part ,
            // if in sorted part , move to right (to find end odf sorted part)
            //else move right
            if(nums[mid-1]<nums[mid] && nums[mid]<nums[mid+1]) low=  mid+1;
            else high = mid-1;
            
            
        }
        return 0;
    }
}
