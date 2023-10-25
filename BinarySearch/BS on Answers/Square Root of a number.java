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
        long prev = 0;
        while(low<=high){

            long mid = (low+high)/2;
            long squared = mid*mid;
            if(squared == N) return (int)mid;
            if(squared>N) high = mid-1;
            else{
				low = mid+1;
				prev=mid;
			} 
        }
        
        return (int)prev;
		 
	}
}
