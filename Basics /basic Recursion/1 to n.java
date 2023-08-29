public class Solution {

    
    public static void help(int idx , int[]arr , int x){
        if(idx==x ) return;
        arr[idx]=idx+1;
        help(idx+1 , arr , x);
    }

    //using Backtracking
    public static void help2( int []arr , int x){
        if(x==-1) return;
        help2(arr , x-1);
        arr[x] =x+1;
    }
    public static int[] printNos(int x) {
        int []arr = new int[x];
     // help(0 , arr , x);
        help2(arr , x-1);
        return arr;
    }
}
