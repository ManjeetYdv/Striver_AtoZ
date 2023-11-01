class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)(m*k)> bloomDay.length) return -1;

        int low = bloomDay[0];
        int high = bloomDay[0];
        
        for(int ele : bloomDay){
            low = Math.min(low , ele);
            high = Math.max(high , ele);
            
        }
        int ans=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isValid(bloomDay , m , k , mid)){
                ans = mid;
                high = mid-1;
            }
            else low =mid+1;
        }
        return ans;

    

    }
    private boolean isValid(int[] nums , int m , int k , int day){
        

        // int bouquets=0;
        // int count=0;

        // for(int ele : nums){
        //     if(ele<=day){
        //         count++;
        //         if(count==k) {
        //             count=0;
        //             bouquets++;
        //         }
        //     }
        //     else count=0;
        //     if(bouquets==m) return true;
        // }

        // return false;

        int bouquets=0;
        int count=0;
        for(int ele : nums){
            if(ele<=day){
                count++;
            }
            else {
                bouquets+= (count/k);
                count=0;
            }
        }

        bouquets+=(count/k);
        return bouquets>=m;

    }
}
