class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans =0;
        
        Stack<Integer>st = new Stack<>();
        
        // add SubArray Maximums
        for(int i=0;i<=n;i++){
            
            while(!st.isEmpty() && (i==n|| nums[st.peek()] <nums[i])){
                
                int top = st.pop();
                int l = top - (st.isEmpty() ? -1 : st.peek() );
                int r =  i - top;
                
                ans +=  (long)nums[top]*l*r;
            }
            st.push(i);
        }
        
        st.clear();
        
        // subtract SubArray Minimums
        for(int i=0;i<=n;i++){
		
            while(!st.isEmpty() && (i==n|| nums[st.peek()] >nums[i])){
                
                int top = st.pop();
                int l = top - (st.isEmpty() ? -1 : st.peek() );
                int r =  i - top;
                
                ans -=  (long)nums[top]*l*r;
            }
            st.push(i);
        }
        
        return ans;

    }
}