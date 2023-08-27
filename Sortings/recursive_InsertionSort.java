public class Solution {
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        sort(0 ,arr , size);
    }
    public static void sort(int idx , int []arr , int size){
        if(idx==size) return;
        int i =idx;

        while(idx>=1 && arr[idx]<arr[idx-1]){
            int temp = arr[idx];
            arr[idx] =arr[idx-1];
            arr[idx-1] = temp;
            idx--;
        }

        sort(i+1  , arr , size);
    }
}
