class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        
        for(int i=1 ;i<nums.length ;i++){
            if(currSum>0){
                currSum+=nums[i];
            }
            else currSum = nums[i];
            maxSum = Integer.max(maxSum , currSum);
        }
        return maxSum;
    }
}

//divide and conquer
// class Solution {
//     public int helper(int []nums , int low , int high){
//         if(low==high) return nums[low];

//         int mid = (low)+(high-low)/2;
//         int leftMax = helper(nums , low , mid);
//         int rightMax = helper(nums , mid+1 , high);
//         int crossMax = findMaxCrossSum(nums , low , mid , high);
//         return Math.max(crossMax , Math.max(leftMax , rightMax));
//     }
//     public int findMaxCrossSum(int []nums , int low , int mid , int high){
//         int left = Integer.MIN_VALUE;
//         int right = Integer.MIN_VALUE;
//         int sum=0;

//         for(int i=mid ;i>=low ;i--){
//             sum+=nums[i];
//             if(sum>left) left=sum;
//         }
//         sum=0;
//         for(int i=mid+1; i<=high;i++){
//             sum+=nums[i];
//             if(sum>right) right=sum;
//         }
        
//         return left+right;
//     }
//     public int maxSubArray(int[] nums) {
//         return helper(nums , 0 ,nums.length-1);
//     }
// }
