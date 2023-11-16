class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     if( n==0) return;
    //     int i=0;
    //     int j=0;
    //     int [] res = new int[m+n];
    //     int idx=0;
    //     while(i<m && j<n){
    //         if(nums1[i]>nums2[j]) {
    //             res[idx++] = nums2[j++];
    //         }
    //         else res[idx++] = nums1[i++];
    //     }

    //     while(i<m) res[idx++] = nums1[i++];
    //     while(j<n) res[idx++] = nums2[j++];
        
    //     for(i=0 ;i<m+n ;i++){
    //         nums1[i]= res[i];
    //     }
    // }
        int idx = m+n-1;
        int i =m-1;
        int j=n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]) nums1[idx--] = nums1[i--];
            else nums1[idx--] = nums2[j--];
        }
        if(j==-1) return;
        while(j>=0) nums1[idx--] = nums2[j--];
    }
}
