/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ********************************QA****************************/

import java.util.*;

public class Solution {
    
    public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    public static void leftBoundayr(TreeNode root , List<Integer> left){
        TreeNode curr = root;
        while(curr!=null){
            if(!isLeaf(curr)) left.add(curr.data);
            if(curr.left!=null) curr= curr.left;
            else curr= curr.right;
        }
    }
    public static void rightBoundary(TreeNode root , List<Integer> right){
        TreeNode curr =root;
        while(curr!=null){
            if(!isLeaf(curr)) right.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
    }
    public static void leafNodes(TreeNode curr , List<Integer> leafs){
        if(curr==null) return;
        if(isLeaf(curr)) {
            leafs.add(curr.data);
            return;
        }
        leafNodes(curr.left , leafs );
        leafNodes(curr.right , leafs);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> rightB = new ArrayList<>();
        List<Integer> leftB= new ArrayList<>();
        List<Integer> leafNodes = new ArrayList<>();
        
        leftBoundayr(root.left ,leftB);
        rightBoundary(root.right , rightB);
        leafNodes(root , leafNodes);
        
        List<Integer> res = new ArrayList<>();
        res.add(root.data);
        
        for(int ele : leftB) res.add(ele);
        for(int ele : leafNodes) res.add(ele);
        for(int i=rightB.size()-1 ;i>=0 ;i--) res.add(rightB.get(i));
        return res;

    }
}
  
