import java.util.* ;
import java.io.*; 
public class Solution {
     public static int ceilingInSortedArray(int n, int x, int[] arr) {
        // Write your code here.
        int floor = floorVal(arr , x);
        int ceil = ceilValue(arr , x);

        System.out.println(floor+" ");
        return ceil;

    }
    public static int floorVal(int[]arr , int x){
        int ans=-1;
        int low =0;
        int high= arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                ans = mid;
                low=mid+1;
            }
            else high = mid-1;
        }
        
        return ans==-1 ? ans : arr[ans];
    
    }
    
    public static int ceilValue(int []arr , int x){
        int ans =-1;
        int low =0;
        int high = arr.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=x) {
                ans = mid;
                high = mid-1;
                
            }
            else low = mid+1;
        }
        return ans==-1 ? ans : arr[ans];
    }
}
