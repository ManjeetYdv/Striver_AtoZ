public class Solution {
    public static int NthRoot(int n, long m) {
        if(m==1) return 1;
        long low=1;
        long high = m;

        while(low<=high){
            long mid = low +(high-low)/2;
            long powered = (long) Math.pow(mid , n);
            if(powered==m) return (int)mid;
            if(powered>m) high = mid-1;
            else low= mid+1;
        }
        return -1;
       
    }
}
