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
    //  int res = -1;
    
    // public int depth(TreeNode root){
    //     if(root==null) return 0;
    //     int left = depth(root.left);
    //     int right = depth(root.right);

    //     res = Math.max(res , left+right);
    //     return Math.max(left , right)+1;
    // }
    // public int diameterOfBinaryTree(TreeNode root) {
    //     int d = depth(root);
    //     return res;
    // }
  //  smater way to eliminate external variable
    //used array becoz that is passed as reference  , unlinke variable
    public int depth(TreeNode root , int[]diameter){
        if(root==null) return 0;
        int left = depth(root.left , diameter);
        int right = depth(root.right ,diameter);

        diameter[0] = Math.max(diameter[0] , left+right);
        return Math.max(left , right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int []diameter = new int[1];
        int d = depth(root , diameter);
        return diameter[0];
    }
}
