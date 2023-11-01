import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {
		if(N==0) return 0;
		/*
		 * Write your code here
		 */
		long low =1;
        long high = N;
    //     long ans=0;
    //     while(low<=high){
    //        long mid =(low+high)/2;
    //        long square = mid*mid;
    //        if(square<=N) {
    //            ans = mid;
    //            low =mid+1;
    //        }
    //        else high = mid-1;
    //    }
    //    return (int)ans;
     
       while(low<=high){
           long mid =(low+high)/2;
           long square = mid*mid;
           if(square<=N) low =mid+1;
           else high = mid-1;
       }
       return (int)high;
		 
	}
}
