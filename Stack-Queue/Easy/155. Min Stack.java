class MinStack {

    private class Node{
        int val;
        int min;
        Node next;
        Node(int val , int min){
            this.val=val;
            this.min=min;
        }
    }
    Node head;
    public MinStack() {
        head=null;
    }

    public void push(int val) {
        if(head==null) {
            head= new Node(val,val);
        }
        else{
            int min=Math.min(head.min , val);
            Node newHead = new Node(val , min);
            newHead.next=head;
            head=newHead;
        }
            
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
