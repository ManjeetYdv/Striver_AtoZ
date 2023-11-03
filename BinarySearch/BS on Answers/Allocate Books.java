import java.util.ArrayList;
public class Solution {
    // brute force
    
    // static int res = Integer.MAX_VALUE;
    // public static void helper(int index , int k , int m , int []alloc ,  int n , ArrayList<Integer> arr){
    //     if(index==n){
    //         if(k==m-1){
    //             int max = Integer.MIN_VALUE;
    //             for(int ele :alloc ) max = Integer.max(max , ele);
    //             res = Integer.min(res  , max);
    //         }
    //         return;
    //     }
    //     //allot to curr
    //     alloc[k]+=arr.get(index);
    //     helper(index+1 , k , m , alloc , n , arr);
        
    //     //allot to next
    //     if(k+1<m){
    //         alloc[k]-=arr.get(index);
    //         alloc[k+1] = arr.get(index);
    //         helper(index+1 , k+1 , m , alloc , n , arr);
    //     }
    // }
    // public static int findPages(ArrayList<Integer> arr, int n, int m) {
    //     // Write your code here.
    //     if(m>n) return -1;
    //     int [] alloc = new int[m];
    //     helper(0 , 0 , m , alloc , n , arr);
    //     return res;
    // }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n) return -1;
        int low = 0;
        int high =0;
        int ans = 0;
        for(int ele : arr){
            low = Math.max(low , ele);
            high +=ele;
        }
        
        while(low<=high){
            int mid =(low+high)/2;
            int studs =canAssign(arr, m, mid);
            // if(studs==m){
            //     ans = mid;
            //     high = mid-1;
            // }
            // else if(studs>m) low = mid+1;
            // else high = mid-1;
            if(studs>m) low = mid+1;
            else{ //studs<= m
                ans= mid;
                high = mid-1;
                } //if studs<=m
        }
        
        return ans; // or return low
    }
    
    public static int canAssign(ArrayList<Integer>arr , int m , int maxAssign){
        int studs=0;
        int assigned=0;
        
        for(int ele : arr){
            if(assigned+ele>maxAssign){
                assigned = ele;
                studs++;
            }
            else assigned+=ele;
        }
        if(assigned<=maxAssign) studs++;
        return studs;
    }
}
