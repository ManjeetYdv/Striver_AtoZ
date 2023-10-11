/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    
    public static void insert(Node head , int val){
        Node newNode = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public static Node constructLL(int []arr) {
        // Write your code here
        Node head = new Node(arr[0]);
        for(int i=1 ; i<arr.length ;i++){
            insert(head , arr[i]);
        }
        return head;


    }
}
