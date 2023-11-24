/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next, Node prev)
     {
         this.data = data;
         this.next = next;
         this.prev = prev;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node insertAtTail(Node list, int K) {
        // Write your code here
        Node head=list;
        Node newNode = new Node(K);

        //base case
        if(head==null){
            head = newNode;
            return head;
        }

        Node temp= head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next = newNode;
        newNode.prev=temp;
        return head;

    }
}
