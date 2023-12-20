/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void dfs(Node root , List<Integer> order){
        if(root==null) return;
        order.add(root.val);
        if(root.children!=null)
            for(Node child : root.children) dfs(child , order);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> order = new ArrayList<>();
        if(root==null) return order;
        dfs(root , order);
        return order;
    }
}
