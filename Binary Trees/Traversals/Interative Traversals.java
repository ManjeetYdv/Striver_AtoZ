package Binary_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class traversals {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            preOrder.add(curr.val);

            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }

        return preOrder;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root==null) return inOrder;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(true){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                curr = stack.pop();
                inOrder.add(curr.val);
                curr = curr.right;
            }
        }
        return inOrder;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root==null) return postOrder;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr.val);

            if(curr.left!=null) stack1.push(curr.left);
            if(curr.right!=null) stack1.push(curr.right);
        }
        while(!stack2.isEmpty()){
            postOrder.add(stack2.pop());
        }

        return postOrder;

    }
    public static void main(String[] args) {

    }
}
