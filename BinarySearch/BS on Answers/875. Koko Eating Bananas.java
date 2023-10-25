class Solution {
    public boolean CanEatALl(int []piles , int h , int k){
        int hrs=0;
        for(int i=0 ;i<piles.length ;i++){
            // int div = piles[i]/k;
            // hrs+=div;
            // if(piles[i]%k!=0) hrs++;
             hrs+= Math.ceil((double)piles[i] / (double)k );
        }
        return hrs<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MAX_VALUE;
        int k = high;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(CanEatALl(piles , h , mid)){
                k=mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return k;
        
    }
}
