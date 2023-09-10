import java.util.*;

public class next_permutation {

    public void nextPermutation(int[] nums) {

        int idx =-1; //breakpoint
        int n=nums.length;

        for(int i=n-2 ;i>=0 ;i--){ //finding breakpoint
            if(nums[i]<nums[i+1]) {
                idx =i;
                break;
            }
        }
        if(idx==-1){ //array is at last permutations or eg , 4331  , so next permuation will be reverse of it i.e 1234
            reverse(nums , 0 , n-1);
            return;
        }

        for(int i=n-1 ; i>idx ;i--){ // finding least greater element than breakpoint and swapping them
            if(nums[i]>nums[idx]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] =temp;
                break;
            }
        }

        //reversing array ahead of idx
        reverse(nums , idx+1, n-1);

    }
    public static void reverse(int []nums , int start , int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
       int []arr = {5,5,4,3,2,1};
        //System.out.println(longestSuccessiveElements(arr));
    }
}

