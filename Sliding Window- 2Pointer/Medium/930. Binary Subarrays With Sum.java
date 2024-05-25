class Solution {
    public int atMost(int[]nums ,int k){
        int i=0;
        int j=0;
        int n=nums.length;
        int sum=0;
        int count=0;
        while(j<n){
            sum+=nums[j];
            while(i<=j && sum>k){
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = atMost(nums ,goal);
        int y=atMost(nums ,goal-1);
        return x-y;
    }
}
