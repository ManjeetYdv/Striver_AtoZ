public class Solution

{
    //recursion
    public static void help2(int idx , int x , int[]arr){
        if(idx==-1) return;
        arr[idx] = x -idx;
        help2(idx-1 , x , arr);
    }
    
    //using backtracking
    public static void help(int idx , int x , int[]arr){
        if(idx==x) return;
        help(idx+1 , x , arr);
        arr[idx] = x-idx;
    }
    public static int[] printNos(int x) {
        int []arr = new int[x];
        //help(0 ,x , arr);
        help2(x-1 , x , arr);
        return arr;
    }
}
