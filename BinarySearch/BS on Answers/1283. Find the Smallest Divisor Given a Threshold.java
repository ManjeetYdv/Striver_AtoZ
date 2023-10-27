class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans=-1;
        int low=1;
        int high = 0;
        for(int ele : nums) high = Math.max(high , ele);
        
        while(low<=high){
            int mid =(low+high)/2;
            int sumOfDiv = getSum(nums , mid);

            if(sumOfDiv<=threshold){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
        
    }
    private int getSum(int []nums , int div){
        int sum=0;
        for(int ele :  nums){
            sum+= (int)Math.ceil((double)ele/(double)div);
        }
        return sum;
    }
}
