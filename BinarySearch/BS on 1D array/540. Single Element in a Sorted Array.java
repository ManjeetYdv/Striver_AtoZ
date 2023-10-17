class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int low =0;
        // int high = nums.length-1;

        // while(low<high){
        //     int mid = (low+high)/2;
        //     if(nums[mid]==nums[mid-1]) low= mid+1;
        //     else if(nums[mid]==nums[mid+1]) high = mid-1;
        //     else return nums[mid];
            
            
        // }
        // return nums[low];

        //brute force
        // if(nums.length==1) return nums[0];

        // for(int i=0 ;i<nums.length ;i++){
        //     if(i==0) {
        //         if(nums[i]!=nums[i+1]) return nums[i];
        //     }
        //     else if(i==nums.length-1){
        //             if(nums[i]!=nums[i-1]) return nums[i];
        //     }
        //     else{
        //         if(nums[i]!=nums[i-1]&& nums[i]!=nums[i+1]) return nums[i];
        //     }
        // }
        // return -1;


        //usign Xor
        // int xor =0;
        // for(int ele : nums) xor = xor^ele;
        // return  xor;
        
        //using binary search
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int low =1;
        int high =n-2;

        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid-1]!= nums[mid] && nums[mid]!=nums[mid+1]) return nums[mid];
            
            if((nums[mid-1]==nums[mid] && mid%2==1) || (nums[mid]==nums[mid+1] && mid%2==0)) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
