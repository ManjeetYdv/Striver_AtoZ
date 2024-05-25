class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // int n=cardPoints.length;
        // int l=n-k;
        // int sum=0;
        // int totalSum=0;
        // int i=0;
        // int j=l;

        // for(int x=0;x<l;x++){
        //     sum+=cardPoints[x];
        // } 
        // totalSum=sum;
        // int minSum=sum;
        // while(j<n){
        //     totalSum+=cardPoints[j];
        //     sum+=cardPoints[j];
        //     sum-=cardPoints[i];
        //     j++;
        //     i++;
        //     minSum= Math.min(minSum ,sum);
        // }
        // return totalSum-minSum;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int maxSum=sum;
        int right=cardPoints.length-1;

        for(int i=k-1;i>=0 ;i--){
            sum-=cardPoints[i];
            sum+=cardPoints[right];
            right--;
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
