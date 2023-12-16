class Solution {

    public double helper(double x , long n){
        if(n==0) return 1;
        if(n%2!=0) return x*helper(x , n-1);
        else return helper(x*x , n/2);
    }
    public double myPow(double x, int n) {
        if(x==0 || x==1) return x;
        long _n=n;   //long n to handle  edge cases of Integer.MIN_VALUE;
        if(n<0) {
            x=1/x;
            _n*=-1;
        }
        return helper(x , _n);
        
    }
}
