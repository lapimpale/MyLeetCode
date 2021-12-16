class MyHashMap {

    static class Node{
        int key; int val; Node next;

        Node(){}
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static Node mp=new Node(-1,-1);
    static Node head=mp;
    
    public MyHashMap() {
        
        mp=new Node(-1, -1);
        head=mp;
    }
    
    public void put(int key, int value) {
        
        head=mp;
        
        while(head.next !=null && head.key!=key) head=head.next;
        
        if(head.next == null && head.key != key){
            Node new_Node = new Node(key, value);
            head.next=new_Node;
        }
        
        else head.val=value;
    }
    
    public int get(int key) {
        
        head=mp;
        
         while(head!=null){
            if(head.key == key){
                return head.val;
            }
            head=head.next;
        }
        return -1;
        
    }
    
    public void remove(int key) {
        
        head=mp;
        
        while(head.next != null){
            if(head.next.key == key ){
                Node tmp = head.next.next;
                head.next=tmp;
                break;
            }
            head=head.next;
        }
    }
}