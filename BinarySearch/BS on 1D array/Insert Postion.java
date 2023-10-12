class Solution {
    public int searchInsert(int[] arr, int target) {
        //lower bound - smallest index such that arr[indx]>=target
        //this applies here
        
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else low= mid+1;
        }
        return ans;
    }
}
