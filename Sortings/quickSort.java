package sorting;

public class quickSort {

    public static void quickSort(int []arr  , int low  , int high){
        if(low<high){
            int p = partition(arr  , low , high);
            quickSort(arr , low , p-1);
            quickSort(arr , p+1 , high);
        }

    }

    static int partition(int []arr , int low , int high){
        int i=low;
        int j=high;
        int pivot = arr[low];

        while(i<j){
            while(arr[i]<=pivot && i<high) i++;
            while(arr[j]>pivot && j>low) j--;

            if(i<j) {
                //swapping i and j index elements
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j]= temp;
        return j;
    }

    public static void main(String[] args) {
        int []arr= {4,3,5,2,1,6};
        quickSort(arr , 0 , arr.length-1);
        for(int ele : arr) System.out.print(ele+" ");


    }
}
