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
    public boolean check(TreeNode t1 , TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null || t1.val!=t2.val) return false;
        
        if(!check(t1.left , t2.right)) return false;
        if(!check(t1.right , t2.left)) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return check(root.left , root.right);
    }
}
