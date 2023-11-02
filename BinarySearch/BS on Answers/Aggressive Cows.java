import java.util.Arrays;
public class Solution {
     public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        // Arrays.sort(stalls);
        
        // int ans=1;
        // int maxD = stalls[stalls.length-1] - stalls[0];
        
        // for(int i=1 ;i<=maxD ;i++){
        //     if(possible(stalls , k ,i)){
        //         ans=i;
        //     }
        //     else break;
        // }
        // return ans;
        Arrays.sort(stalls);
       int low=1;
       int high =stalls[stalls.length-1] - stalls[0];
     
       int ans=1;
       while(low<=high){
           int mid = (low+high)/2;
           if(possible(stalls , k , mid)){
               ans = mid;
               low = mid+1;
           }
           else high = mid-1;
       }
       return ans;
    }
    public static boolean possible(int []stalls , int cow  , int minD){
        int last = stalls[0];
        cow--;

        for(int i=1 ;i<stalls.length ;i++){
            if(stalls[i]-last >=minD){
                cow--;
                last = stalls[i];
            }
            if(cow==0) return true;
        }
        return false;
    }
}
