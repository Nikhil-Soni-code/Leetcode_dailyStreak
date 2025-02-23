class Pair{
    int key;
    int value;
    public Pair(int key,int value){
        this.key = key;
        this.value=value;
    }
}
class StockSpanner {
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack();
    }
    
    public int next(int price) {
        int count=1;
        while(!stack.isEmpty()&&stack.peek().key<=price){
            count+=stack.pop().value;
        }        
        Pair pair = new Pair(price,count);
        stack.push(pair);
        return count;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */