class MyStack {
    Queue<Integer> stackQueue;
    int top=-1;
    public MyStack() {
         stackQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        top=x;
        stackQueue.add(x);
    }
    
    public int pop() {
        int res=-1;
        int n=stackQueue.size()-1;
        while(n>0){
          top=  stackQueue.peek();
              stackQueue.remove();
            n--;
            stackQueue.add(top);
        }
        res=stackQueue.peek();
        stackQueue.remove();
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return stackQueue.isEmpty();
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