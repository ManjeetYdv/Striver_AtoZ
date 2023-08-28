class Solution {
    public void rotate(int[] nums, int k) {
        // if(k==0) return;
        // k = k%nums.length;
        // int[] arr =new int[k];
        // int idx=0;
        // for(int i=nums.length-k ;i<nums.length ;i++){
        //     arr[idx++] = nums[i];
        // }
        // for(int i=nums.length-1-k ;i>=0 ;i--){
        //     nums[i+k]=  nums[i];
        // }
        // for(int i=0 ;i<k ;i++){
        //     nums[i]= arr[i];
        // }
        k = k%nums.length;
        revArr(nums , 0 , nums.length-1-k);
        revArr(nums , nums.length-k , nums.length-1);
        revArr(nums , 0 , nums.length-1);
  }
    public void revArr(int[]arr , int start , int end){
        for(int i=start ;i<=(start+end)/2 ;i++){
            int oppIdx= end -(i-start);
            int temp = arr[oppIdx];
            arr[oppIdx] = arr[i];
            arr[i] =temp;
        }
    }

}
