import java.util.*;
public class Solution {
    public static int mergeSort(int low , int high , int[]a){
        int count=0;
        if(low<high){
            int mid = (low+high)/2;
            count+=mergeSort(low ,mid ,a);
            count+=mergeSort(mid+1 , high , a);
            count+=merge(low , mid , high , a);

        }
        return count;
    }
    public static int merge(int low , int mid ,int high , int[]a){
        int inversion=0;
        List<Integer> temp = new ArrayList<>();

        int i=low;
        int j=mid+1;

        while(i<=mid && j<=high){
            if(a[i]>a[j]){
                inversion += (mid-i+1); //imp
                temp.add(a[j++]);
            }
            else temp.add(a[i++]);
        }

        while(i<=mid) temp.add(a[i++]);
        while(j<=high) temp.add(a[j++]);

        for(int k=low ;k<=high ;k++){
            a[k] = temp.get(k-low);
        }

        return inversion;

    }
    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        // int count=0;
        // for(int i=0 ;i<n-1 ;i++){
        //     for(int j=i+1  ;j<n ;j++){
        //         if(a[i]>a[j]) count++;
        //     }
        // }
        // return count;
        return mergeSort(0 , n-1 , a);

    }
}
