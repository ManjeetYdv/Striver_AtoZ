
public class Solution {
	
	public static int gcd(int m,int n)
	{

    //using euclidean algorithm
    // while(m!=n){
    //         if(m>n){
    //             m=m-n;
    //         }
    //         else n= n-m;
    //     }
    //     return m;

    //optimized euclidean algorithm
		if(m==0) return n;
        if(n==0) return m;
        
        if(m>n) return gcd(m%n , n);
        else return gcd(m , n%m);
	}		
}
