public class Solution {
    public static int lowerBound(int arr[] , int n , int x){
        int ans = n;
        int low =0;
        int high = n-1;

        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int first = lowerBound(arr , n , x);
        int last = lowerBound(arr , n, x+1)-1;

        return last-first+1;
    }
}
