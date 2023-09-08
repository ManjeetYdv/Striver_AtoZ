class Solution {
    public void nextPermutation(int[] nums) {
        boolean swap=false;
        
        for(int i=nums.length-1 ;i>0 ;i--)
        {
            if(nums[i-1]<nums[i]){
                swap = true;
                int ele = nums[i-1];
                int just_greater_ele = nums[i];
                int just_greater_idx =i;
                for(int j=i ;j<nums.length ;j++){
                    if(nums[j]>ele && nums[j]<=just_greater_ele){
                        just_greater_ele =nums[j];
                        just_greater_idx =j;
                    }
                }
                
                int temp = nums[just_greater_idx];
                nums[just_greater_idx] = ele;
                nums[i-1] = temp;
                 
                //reverse from i to last
                reverse(nums , i , nums.length-1);
                
                break;
            }
        }
        
        if(!swap) reverse(nums , 0 , nums.length-1);
    }

      public static void reverse(int []nums , int start , int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
