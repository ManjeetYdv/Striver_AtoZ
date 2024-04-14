class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=1;
        int r=n-2;
        int leftMax=height[0];
        int rightMax=height[n-1];
        int water = 0;
        while(l<=r){
           if(leftMax<rightMax){
              leftMax=Math.max(leftMax , height[l]);
              water+= leftMax-height[l];
              l++;
           }
           else {
              rightMax=Math.max(rightMax , height[r]);
              water+= rightMax-height[r];
              r--;
           }
        }
        return water;
    }
} 
