
class Solution {
    public List<Integer> replaceNonCoprimes(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        for (int v : arr) {
            push(stack, v);
        }
        
        return new ArrayList<>(stack);
    }
    
    private void push(Stack<Integer> stack, int v) {
        if (stack.isEmpty()) {
            stack.push(v);
            return;
        }
        int gcd = gcd(stack.peek(), v);
        if (gcd == 1) {
            stack.push(v);
        } else {
            int lcm = v / gcd * stack.pop();
            push(stack, lcm);
        }
        
        
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
}