class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
         int count=0;
        int res=0;
        for(int ele : nums){
            if(ele==1) count++;
            else {
                res = Math.max(res , count);
                count=0;
            }
        }
        res = Math.max(res , count);
        return res;
    }
}
