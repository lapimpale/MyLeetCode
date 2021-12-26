class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
       size = 0;
        head = new ListNode();
    }
    
    public int get(int index) {
        ListNode cur = head;
        if(index >= size || size == 0) {
            return -1;
        }
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.next.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
       addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
         ListNode newNode = new ListNode(val);
        ListNode cur = head;
        if(index > size) return;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        ListNode cur = head;
         if(size < 0 || index >= size) {
             return ;
        }
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */