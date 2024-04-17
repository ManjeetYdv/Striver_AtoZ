class StockSpanner {

    private class Pair{
        int val;
        int prevs;
        public Pair(int val  , int prevs){
            this.val=val;
            this.prevs=prevs;
        }
    }
    
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count=1;
        while(!stack.isEmpty() && stack.peek().val<=price){
            count+=stack.pop().prevs;
        }
        stack.push(new Pair(price , count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
