class LRUCache {
    class ListNode {
        private int key;
        private int val;
        private ListNode next;
        
        private ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private int capacity;
    
    ListNode dummy = new ListNode(0, 0);
    ListNode end = dummy;
    
    Map<Integer, ListNode> mapOfPrevious = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {    
        if (!mapOfPrevious.containsKey(key)) {
            return -1;
        }
        
        ListNode prev = mapOfPrevious.get(key);
        ListNode node = prev.next;
        
        //push node to the latest
        pushToEnd(prev);      

        
        return node.val;
    }
    
    public void put(int key, int value) {
        //if exists
        if (mapOfPrevious.containsKey(key)) {
            ListNode prev = mapOfPrevious.get(key);
            ListNode node = prev.next;
            
            //update value
            node.val = value;
            
            //push node to the latest
            pushToEnd(prev);      
            
        } else {
            //if not exists
            ListNode node = new ListNode(key, value);
            mapOfPrevious.put(key, end);
            
            //add to linked list
            end.next = node;
            end = node;
            
            size++;
            
            //eviction logic
            if (size > capacity) {
                ListNode evict = dummy.next;
                mapOfPrevious.remove(evict.key);
                
                //update map
                mapOfPrevious.put(dummy.next.next.key, dummy);
                
                dummy.next = dummy.next.next;
                
                size--;
            }
        }
    }
    
    public void pushToEnd(ListNode prev) {
        ListNode node = prev.next;
        if (node == end) {
            return;
        }
        
        //update map
        mapOfPrevious.put(prev.next.next.key, prev);
        
        //de-link
        prev.next = prev.next.next;
        node.next = null;
        
        //update map
        mapOfPrevious.put(node.key, end);
        
        //re-link
        end.next = node;
        end = node;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */