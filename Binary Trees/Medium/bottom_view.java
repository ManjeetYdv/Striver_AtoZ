/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class pair{
    TreeNode node;
    int col;
    public pair(){}
    public pair(TreeNode node , int col){
        this.node=node;
        this.col =col;
    }
}
public class Solution {
   
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.  
        TreeMap<Integer , Integer> map = new TreeMap<>();
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root , 0));
        
        while(!queue.isEmpty()){
            pair curr = queue.poll();
            TreeNode node =curr.node;
            int col = curr.col;
            
            map.put(col , node.val);
            
            if(node.left!=null) queue.add(new pair(node.left ,col-1));
            if(node.right!=null) queue.add(new pair(node.right ,col+1));
        }
        
        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet()) res.add(map.get(key));
        return res;
        
    }
}
