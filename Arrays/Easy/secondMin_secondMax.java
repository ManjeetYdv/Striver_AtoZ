//#solution -1
  public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        
        int max1;
        int max2;
        int min1;
        int min2;
        if(a[0]>a[1]){
            max1 = a[0];
            max2 = a[1];

            min1 = a[1];
            min2 = a[0];
        }
        else {
            max1 = a[1];
            max2 = a[0];

            min1 = a[0];
            min2 =a[1];
        }

        for(int i=2 ;i<a.length ;i++){
            if(a[i]>max1){
                max2 = max1;
                max1 = a[i];
            }
            else if(a[i]>max2){
                max2 = a[i];
            }

            if(a[i]<min1){
                min2 = min1;
                min1 = a[i];
            }
            else if(a[i]<min2){
                min2 = a[i];
            }
        }
         int[] res ={max2 , min2};
         return res;

        
    }

}
