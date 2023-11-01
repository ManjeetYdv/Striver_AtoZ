class Solution {
      public int shipWithinDays(int[] weights, int days) {
//        int low=1;
//        int high=Integer.MAX_VALUE;

        //if weight capacity is equal to highest weight  ,
        //then it is the sure min that we can lift any bag , so low is highest weight and if capacity equals sum of all weights then num of days will be 1
        //this will be our rage
        int low = Integer.MIN_VALUE;
        int high=0;
        for(int ele : weights){
            low = Math.max(low , ele);
            high+=ele;
        }

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
    private static boolean CanShip(int []weights , int days , int weight){
        int tempDays=0;
        int sum=0;

        for(int ele : weights){
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
