class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // List<Integer> res = new ArrayList<>();
        // int count=1;
        // int n = nums.length;
        // for(int i=1 ;i<n ;i++){
        //     if(nums[i]!=nums[i-1]){
        //         if(count>n/3) res.add(nums[i-1]);
        //         count=1;
        //     }
        //     else count++;
        // }

        // if(count>n/3) res.add(nums[n-1]);
        // return res;
        List<Integer> res = new ArrayList<>();
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        int n = nums.length;

        for(int i=0 ;i<n ;i++){
            if(count1==0 && nums[i]!=ans2) {
                ans1 = nums[i];
                count1=1;
            }
            else if(count2==0 && nums[i]!=ans1){
                ans2 = nums[i];
                count2=1;
            }
            else if(nums[i]==ans1) count1++;
            else if(nums[i]==ans2) count2++;
            else{
                count1--;
                count2--;
            }
        }

        int freq1=0;
        int freq2=0;

        for(int i=0 ;i<n ;i++){
            if(nums[i]==ans1) freq1++;
            if(nums[i]==ans2) freq2++;
        }
        if(freq1>n/3) res.add(ans1);
        if(freq2>n/3) res.add(ans2);

        return res;
        
    }

}
