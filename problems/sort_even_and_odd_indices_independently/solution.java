class Solution {
    public int[] sortEvenOdd(int[] nums) {
        Stack<Integer> es = new Stack<Integer>();  
        Stack<Integer> os = new Stack<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(i ==0 || i%2==0){
                es.push(nums[i]);
            } else {
                os.push(nums[i]);
            }
        }
        
        es = reversesortstack(es);
        os = sortstack(os);
        
        for(int i = 0; i < nums.length; i++){
            if(i ==0 || i%2==0){
                nums[i] = es.pop();
            } else {
                nums[i] = os.pop();
            }
        }
        
        
        return nums;
    }
    
    public static Stack<Integer> sortstack(Stack<Integer>
                                             input)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();
         
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek()
                                                 > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
            input.push(tmpStack.pop());
            }
             
            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
    
    public static Stack<Integer> reversesortstack(Stack<Integer>
                                             input)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();
         
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek()
                                                 < tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
            input.push(tmpStack.pop());
            }
             
            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}