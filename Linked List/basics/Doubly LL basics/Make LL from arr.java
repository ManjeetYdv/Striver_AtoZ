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

    public static Node constructDLL(int []arr) {
     
        Node head = null;
        Node tail = null;

        for(int i=0 ;i<arr.length;i++){
            if(i==0){
                head = new Node(arr[0]);
                tail = head;
             }
            else{
                Node newNode = new Node(arr[i]);
                tail.next =newNode;
                newNode.prev = tail;
                tail = tail.next;
            }
        }
        return head;

        // Node head = null;
        // for(int i=0 ;i<arr.length ;i++){
        //     head = addNode(head , arr[i]);
        // }
        // return head;

    }
    // public static Node addNode(Node head, int ele){
    //     Node newNode = new Node(ele);
    //     if(head==null){
    //         head= newNode;
    //         return head;
    //     }
    //     Node temp = head;
    //     while(temp.next!=null) temp = temp.next;

    //     newNode.prev=temp;
    //     temp.next =newNode;
    //     return head;


    // }
}
