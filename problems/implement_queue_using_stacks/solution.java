class MyQueue {
    Stack<Integer> inputStack = new Stack();
    Stack<Integer> outputStack = new Stack();
    
    public void push(int x) {
     inputStack.push(x);   
    }
    
    public int pop() {
        if(outputStack.empty()){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
        
        return outputStack.pop();
    }
    
    public int peek() {
        if(outputStack.empty()){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }
        
        return outputStack.peek();
        
    }
    
    public boolean empty() {
        if(inputStack.empty() && outputStack.empty()){
            return true;
        } else {
            return false;
        }
    }
}