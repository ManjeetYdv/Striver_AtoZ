class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int l=n-k;
        int sum=0;
        int totalSum=0;
        int i=0;
        int j=l;

        for(int x=0;x<l;x++){
            sum+=cardPoints[x];
        } 
        totalSum=sum;
        int minSum=sum;
        while(j<n){
            totalSum+=cardPoints[j];
            sum+=cardPoints[j];
            sum-=cardPoints[i];
            j++;
            i++;
            minSum= Math.min(minSum ,sum);
        }
        return totalSum-minSum;
    }
}
