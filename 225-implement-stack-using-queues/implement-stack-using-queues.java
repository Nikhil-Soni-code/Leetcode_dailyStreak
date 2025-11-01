class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue=new LinkedList();
    }
    
    public void push(int x) {
        queue.add(x);
        int size=queue.size();

        for(int i=0;i<size-1;i++){
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.remove();
    }
    
    public int top() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }
    
    public boolean empty() {
        if(queue.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */