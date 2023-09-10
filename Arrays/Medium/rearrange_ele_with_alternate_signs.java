//Variety -1 
//equal number of positve and negative
import java.util.*;

class TUF{

public static int[] RearrangebySign(int[] A, int n){

    //BRUTE FORCE
  ArrayList<Integer> pos=new ArrayList<>();
  ArrayList<Integer> neg=new ArrayList<>();

  for(int i=0;i<n;i++){
      
      if(A[i]>0) pos.add(A[i]);
      else neg.add(A[i]);
  }
  
  // Positives on even indices, negatives on odd.
  for(int i=0;i<n/2;i++){
      
      A[2*i] = pos.get(i);
      A[2*i+1] = neg.get(i);
  }
    return A;
}  

    //optimal
    public int[] rearrangeArray(int[] nums) {
        
        int[]res = new int[nums.length];
        int pos=0; //all positives at even indexes
        int neg =1; //all negatives at off indexes
        
        for(int i=0 ;i<nums.length ;i++){
            if(nums[i]>0) {
                res[pos] = nums[i];
                pos+=2;
            }
            else {
                res[neg] = nums[i];
                neg+=2;
            }
        }
        return res;
    }
    

public static void main(String args[]) 
{
  // Array Initialisation.
  int n = 4;
  int A[]= {1,2,-4,-5};


  int[]ans= RearrangebySign(A,n);
  
  for (int i = 0; i < n; i++) {
    System.out.print(ans[i]+" ");
  }

}
}



