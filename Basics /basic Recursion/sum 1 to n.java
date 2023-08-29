public class Solution {
    public static long sumFirstN(long n) {
        // Write your code here.

        //stackoverflow
        // if(n==0) return 0;
        // return n+sumFirstN(n-1);

        return n*(n+1)/2;
    }
}
