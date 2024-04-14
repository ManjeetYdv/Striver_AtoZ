import java.util.*;
class Pair{
    int val;
    int index;
    public Pair(int val ,int index){
        this.val=val;
        this.index=index;
    }
}
public class Solution {
   static  int[] nextg;
    public static void merge(int low , int mid , int high , Pair[]nums){
        List<Pair>list= new ArrayList<>();
        int i=low;
        int j=mid+1;

        while(i<=mid && j<=high){
            if(nums[i].val<nums[j].val){
                    nextg[nums[i].index]+= high-j+1;
                    list.add(nums[i++]);
             }
             else list.add(nums[j++]);
        }
        while(i<=mid) list.add(nums[i++]);
        while(j<=high) list.add(nums[j++]);

        for(int k=low ;k<=high; k++){
            nums[k]=list.get(k-low);
        }
    }
    public static void mergeSort(int low , int high , Pair []nums){
        if(low>=high) return ;
        int mid =(low+high)/2;
        mergeSort(low , mid ,nums);
        mergeSort(mid+1 , high , nums);
        merge(low , mid , high , nums);
    }
    public static int[] countGreater(int []arr, int []query) {
       
        int n = arr.length;
        nextg = new int[n];
        Pair[]nums = new Pair[n];
        for(int i=0;i<n ;i++) nums[i] = new Pair(arr[i] , i);

        mergeSort(0 , n-1 , nums);
        int []ans = new int[query.length];

        int index=0;
        for(int idx :  query) ans[index++] = nextg[idx];
        return ans;
        
    }
}
