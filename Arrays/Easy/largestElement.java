import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        int max = arr[0];
        for(int ele : arr){
            if(ele > max) max = ele;
        }
        return max;

    }
}
