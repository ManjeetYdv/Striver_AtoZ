package Binary_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_traversals {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            order.add(node.val);

            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return order;
    }
    public static void main(String[] args) {

    }
}
