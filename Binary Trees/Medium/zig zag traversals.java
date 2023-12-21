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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        boolean oddLevel = false;
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
               TreeNode curr = queue.poll();
               list.add(curr.val);
               
               if(curr.left!=null) queue.add(curr.left);
               if(curr.right!=null) queue.add(curr.right);
            }

            if(oddLevel) Collections.reverse(list);
            res.add(new ArrayList<>(list));
          
            oddLevel =!oddLevel;
        }
        return res;
    }
}
