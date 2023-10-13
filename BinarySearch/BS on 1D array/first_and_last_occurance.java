 class Solution{
     public int lowerBound(int[]arr , int target){
        int low =0;
        int high =arr.length-1;
        int ans=arr.length;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=target){
                ans = mid;
                high=mid-1;
            }
            else low = mid+1;
        }
        return ans;
        
    }
    public int[] searchRange(int[]nums , int target){
        if(nums.length==0) return new int[]{-1  , -1};
        int[] res = {-1 , -1};
        int first =  lowerBound(nums , target);
        int last = lowerBound(nums ,target+1)-1;
        
        if(first==nums.length || nums[first]!=target) return res;
        res[0]= first;
        res[1] = last;
        
        return res;
    }
 } 
