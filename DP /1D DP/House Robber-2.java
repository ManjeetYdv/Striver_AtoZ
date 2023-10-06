class Solution {

    //space optimzed dp code from robber-1
    public int help(int []nums){
        int n = nums.length;
        int prev1= nums[0];
        int prev2 = 0;

        for(int i=1 ;i<n ;i++){
            int take = nums[i] + prev2;
            int skip = prev1;

            int cur_i= Integer.max(take , skip);
            prev2 = prev1;
            prev1 = cur_i;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        //using house robber 1's logic
        //since both first and last cant be int the subsequence , apply robber-1 logic to 
        // 0 , n-1 and 1 to n  , and return max of two\
        int n = nums.length;
        if(n==1) return nums[0];

        int []temp = new int[n-1];
        int idx=0;
        for(int i=0 ;i<n-1 ;i++){
            temp[idx++] = nums[i];
        }

        int res= help(temp);

        idx=0;
        for(int i=1 ;i<n ;i++){
            temp[idx++] = nums[i];
        }

        res = Integer.max(res , help(temp));
        return res;
        


    }
}
