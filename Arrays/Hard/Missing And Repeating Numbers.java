import java.util.HashMap;

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []nums) {
        // Write your code here
        // int slow=nums[0];
        // int fast = nums[0];

        // do {
        //     slow = nums[slow-1];
        //     fast = nums[nums[fast]-1];
        // }
        // while(slow!=fast);

        // slow = nums[0];

        // while(slow!=fast){
        //     slow = nums[slow-1];
        //     fast = nums[fast-1];
        // }
        // return new int[]{slow , 0};
        // int []res = new int[2];
        // int n = nums.length;
        // int sumOfN = n*(n+1)/2;
        // int sum=0;

        // HashMap<Integer , Integer> map = new HashMap<>();
        // for(int ele : nums) {
        //     sum+=ele;
        //     map.put(ele , map.getOrDefault(ele, 0)+1);
        // }

        // for(int key : map.keySet()){
        //     if(map.get(key)==2){
        //         res[0] = key;
        //         break;
        //     }
        // }

        // res[1] = sumOfN -(sum-res[0]);
        // return res;

        //mathematical approach
        int x ,y; // x is repeating number and y is missing number
        long n = nums.length;
        long sumOfN = n*(n+1)/2;
        long sumOfNsq = n*(n+1)*(2*n+1)/6;

        long sum_ele=0;
        long sumSq_ele=0;

        for(int ele : nums){
            sum_ele +=(long)ele;
            sumSq_ele += (long)ele* (long)ele;
        }

        //to get x-y
        long diff = sum_ele - sumOfN;
        
        //to get x^2-y^2
        long diff2 = sumSq_ele - sumOfNsq;

        //to get x+y
        //x^2-y^2/x-y
        long diff3 = diff2/diff;

        //diff = x-y
        //diff3 - x+y;
        // x = (diff + diff2)/2
        x = (int)(diff + diff3)/2;
        y =(int)( diff3 - x);
        return new int[]{x,y};


    }
}
