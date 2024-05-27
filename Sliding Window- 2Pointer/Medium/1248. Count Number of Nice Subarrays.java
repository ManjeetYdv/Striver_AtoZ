class Solution {
    public int atMost(int []nums ,  int k){
        int i=0;
        int j=0;
        int n=nums.length;
        int odds=0;
        int res=0;
        while(j<n){
            if(nums[j]%2==1) odds++;
            while(i<=j && odds>k){
                if(nums[i]%2==1) odds--;
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int atMostK =atMost(nums ,k);
        int atMostK_1 =atMost(nums ,k-1);
        return atMostK-atMostK_1;
    }
}
