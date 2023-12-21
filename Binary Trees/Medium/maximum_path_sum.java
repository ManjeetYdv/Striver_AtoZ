/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   
    public int dfs(TreeNode root , int []maxP){
        if(root==null) return 0;
        int left = Math.max(0 , dfs(root.left , maxP));
        int right = Math.max(0 , dfs(root.right , maxP));

        maxP[0] = Math.max(maxP[0] , left+right+root.val);
        return Math.max(left , right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int []maxP = new int[1];
        maxP[0] = Integer.MIN_VALUE;
        dfs(root , maxP);
        return maxP[0];
    }
}
