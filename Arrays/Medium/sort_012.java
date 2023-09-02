class Solution {
    public void sortColors(int[] nums) {
        //brute force
        // int zeroes=0;
        // int ones=0;
        // int twos=0;

        // for(int ele : nums){
        //     if(ele==0) zeroes++;
        //     else if(ele==1) ones++;
        //     else twos++;
        //  }
        // int idx=0;
        // for(int i=0;i<zeroes;i++) nums[idx++]=0;
        // for(int i=0 ;i<ones; i++) nums[idx++]=1;
        // for(int i=0 ;i<twos ;i++) nums[idx++]=2;

        //using dutch national flag algorithm
        int low=0;
        int mid=0;
        int high = nums.length-1;
        
        while(mid<=high){
            if(nums[mid]==0){
               swap(low , mid , nums);
               low++;
               mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                swap(mid , high , nums);
                high--;
            }
        }
    }
    public void swap(int i, int j , int[]arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
