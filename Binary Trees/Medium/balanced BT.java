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

    //optimal
     public int depth(TreeNode root){ //smarter way
        if(root==null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        if(left==-1 || right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;

        return Math.max(left , right)+1;
    }
    public boolean isBalanced(TreeNode root) {
       return depth(root)!=-1;
    }

    //time  = N^2
    // public int depth(TreeNode root){
    //     if(root==null) return 0;
    //     int left = depth(root.left);
    //     int right = depth(root.right);
    //     return Math.max(left ,right)+1;
    // }

    // public boolean check(TreeNode root){
    //     if(root==null) return true;
    //     int l = depth(root.left);
    //     int r = depth(root.right);

    //     if(Math.abs(l-r)>1) return false;
        
    //     //else
    //     boolean left = check(root.left);
    //     boolean right = check(root.right);

    //     if(!left || !right) return false;
    //     return true;
    // }

    // public boolean isBalanced(TreeNode root) {
    //     return check(root);
    // }


    //uses global variable (boo)
    // boolean balanced = true;

    //  public int maxDepth(TreeNode root) {
    //     if(root==null) return 0;
    //     int left = maxDepth(root.left);
    //     int right = maxDepth(root.right);

    //     if(Math.abs(left-right)>1) balanced = false;
    //     return Math.max(left , right)+1;
    // }


   
}
