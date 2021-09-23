class Solution {
    public int findMinFibonacciNumbers(int k) {
       if(k <= 0) return 0;
        
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        
        int i = 2;
        
        while(fib.get(i - 1) <= k){
            fib.add(fib.get(i - 1) + fib.get(i - 2));
            i++;
        }
        
        i--;
        int ans = 0;
        while(k > 0){
            int current = fib.get(i);
            if(current <= k){
                k -= current;
                ans++;
                continue;
            }
            i--;
        }
        
        return ans;
    }
}