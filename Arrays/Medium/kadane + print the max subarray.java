import java.util.ArrayList;
import java.util.List;

public class maximum_sum_subarray {
    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = Long.MIN_VALUE;
        long currSum=0;

        for(int ele : arr){
            currSum+=ele;
            if(currSum>maxSum) maxSum = currSum;
            if(currSum<0) currSum=0;
        }
        return maxSum;
    }

    public static List<Integer> maxSubarraySum(int []arr){
        List<Integer> res = new ArrayList<>();
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0;
        int ansStart =-1;
        int ansEnd = -1;


        for(int i=0; i<arr.length ;i++){
            if(currSum ==0) start=i; //start of subarray , coz if subarray sum gets -ve we dont consider it and start again with currSUm 0
            currSum+=arr[i];

            if(currSum>maxSum){
                maxSum = currSum;
                ansStart =start; //keep track of start and end  , and only updated when we found a subarray with sum greater than currSum
                ansEnd =i;
            }
            if(currSum<0) currSum=0;

        }
        for(int i=ansStart; i<=ansEnd ;i++) res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {
        int[]arr = {2,1,-3,4,-1,2,1,-5,4};
        List<Integer> list = maxSubarraySum(arr);
        System.out.println(list);
    }
}
