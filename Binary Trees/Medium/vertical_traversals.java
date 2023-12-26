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
class Tuple{
    int x;
    int y;
    TreeNode node;
    public Tuple(){}
    public Tuple(TreeNode node , int x , int y){
        this.node=node;
        this.x =x;
        this.y =y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root , 0 , 0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode curr = tuple.node;
            int row =tuple.x;
            int col = tuple.y;

            if(!map.containsKey(col)) map.put(col , new TreeMap<>());
            if(!map.get(col).containsKey(row)) map.get(col).put(row , new PriorityQueue<>());

            map.get(col).get(row).add(curr.val);

            if(curr.left!=null) queue.add(new Tuple(curr.left , row+1 , col-1));
            if(curr.right!=null) queue.add(new Tuple(curr.right , row+1 , col+1));
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int col : map.keySet()){
            TreeMap<Integer , PriorityQueue<Integer>> vertical = map.get(col);
            List<Integer> list = new ArrayList<>();
            
            for(int row : vertical.keySet()){
                PriorityQueue<Integer> entries = vertical.get(row);
                while(!entries.isEmpty()) list.add(entries.poll());
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
    
}
