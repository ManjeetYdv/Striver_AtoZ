public class Solution {
    public static int findKRotation(int []arr){
        // Write your code here.
        //number of rotations  = index of smallest element
        int min = Integer.MAX_VALUE;
        int res =0;
        int low=0;
        int high= arr.length-1;

        while(low<=high){
            int mid =(low+high)/2;

            //if left is sorted
            if(arr[low]<=arr[mid]){
                if(arr[low]<min){
                    min = arr[low];
                    res = low;
                }
                low = mid+1;
            }
            //if right is sorted
            else { 
                if(arr[mid]<min){
                    min = arr[mid];
                    res=mid;
                }
                high = mid-1;
            }
        } 

        return res;  
         
    }
}
