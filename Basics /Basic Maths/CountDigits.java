public class Solution {
    public static int countDigits(int n){
        // Write your code here.
        int orig = n;
        int count=0;
        while(n>0){
            int l = n%10;
            if(l!=0 && orig%l==0) count++;
            n=n/10;
        }
        return count;
    }
}
