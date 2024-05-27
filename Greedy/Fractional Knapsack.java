class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        double amount=0;
        for(int i=0;i<n;i++){
            if(arr[i].weight<=w) {
                amount += arr[i].value;
                w-=arr[i].weight;
            }
            else {
                amount+=((double)arr[i].value/arr[i].weight)*w;
                break;
            }
        }
        return amount;
    }
}
