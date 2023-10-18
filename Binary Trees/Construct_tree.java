/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
       public static Node helper(Node root , int ele){
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.left ==null){
                curr.left = new Node(ele);
                return root;
            }
            else queue.add(curr.left);
            
            if(curr.right==null){
                curr.right = new Node(ele);
                return root;
            }
            else queue.add(curr.right);
            
        }
        return root;
    }
    public static Node createTree(int []arr){
        // Write your code here.
        Node root = new Node(arr[0]);
        for(int i=1 ;i<arr.length ;i++){
            root = helper(root , arr[i]);
        }
        return root;
    }
}
