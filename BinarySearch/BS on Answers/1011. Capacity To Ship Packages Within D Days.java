class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=1;
        int high=Integer.MAX_VALUE;
        int weight =0;
        
        while(low<=high){
            int mid = low +(high-low)/2;
            if(CanShip(weights , days , mid)){
                weight = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return weight;
    }
    private boolean CanShip(int []weights , int days , int weight){
        int tempDays=0;
        int sum=0;
        
        for(int ele : weights){
            if(ele>weight) return false;
            sum+=ele;
            
            if(sum>weight){
                tempDays++;
                sum = ele;
            }
        }
        if(sum<=weight) tempDays++;
        return tempDays<=days;
    }
}
