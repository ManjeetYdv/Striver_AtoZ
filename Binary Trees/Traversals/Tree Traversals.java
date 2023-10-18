/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.List;
import java.util.ArrayList;
public class Solution {

    public static void traverse(TreeNode root , List<Integer>inOrder , List<Integer>preOrder , List<Integer>postOrder){
        if(root==null) return;

        preOrder.add(root.data);
        traverse(root.left , inOrder , preOrder , postOrder);
        inOrder.add(root.data);
        traverse(root.right , inOrder , preOrder , postOrder);
        postOrder.add(root.data);
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        traverse(root , inOrder , preOrder , postOrder);
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);

        return res;

    }
}
