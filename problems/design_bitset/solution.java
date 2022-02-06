class Bitset {
    boolean [] arr = null;
    int flipCount = 0;
    int falseCount = 0;
    public Bitset(int size) {
        arr = new boolean[size];
        falseCount = size;
    }
    
    public void fix(int idx) {
        boolean realTrue = true;
        boolean realFalse = false;
        if(flipCount%2==1)
        {
            realTrue = false;
            realFalse = true;
        }
        
        if(arr[idx]==realFalse) // Write code first with false and true, then replace with the realFalse, realTrue to accomodate flips
            falseCount--;
        
        arr[idx]=realTrue;
    }
    
    public void unfix(int idx) {
        boolean realTrue = true;
        boolean realFalse = false;
        if(flipCount%2==1)
        {
            realTrue = false;
            realFalse = true;
        }
        
        if(arr[idx]==realTrue)
            falseCount++;
        
       arr[idx] = realFalse; 
    }
    
    public void flip() {
        falseCount = arr.length-falseCount;
        
        flipCount++;
    }
    
    public boolean all() {
        return (falseCount==0);
    }
    
    public boolean one() {
        return falseCount<arr.length;
    }
    
    public int count() {
        return arr.length-falseCount;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();;
        for(boolean val: arr){
            sb.append(""+((flipCount%2==0)?(val?1:0):(val?0:1)));
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */