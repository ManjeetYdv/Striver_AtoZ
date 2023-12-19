public class Solution {
    static  ArrayList<Integer> list;
    public static void func(int[] arr , int index , int sum ){
        if(index==arr.length){
            list.add(sum);
            return;
        }
        
        func(arr , index+1 ,sum+arr[index] );
        func(arr , index+1 ,sum );
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
         list = new ArrayList<>();
        func(arr , 0 , 0 , list);
        return list;
        
    }

}
