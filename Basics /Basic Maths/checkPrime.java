public class Solution {
	public static String isPrime(int n) {
		//Your code goes here
		if(n==1) return "NO";
		for(int i=2 ;i<=(int)Math.sqrt(n) ;i++){
            if(n%i==0){
				
				return "NO";
			}
        }
	
        return "YES";
	}
}
