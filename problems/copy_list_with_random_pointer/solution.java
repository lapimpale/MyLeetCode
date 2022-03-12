/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null)
            return null;
        
        Node current = head;
        
        // Merging two linkedlists where original node is followed by copied node 
        while(current != null)
        {
            Node copy = new Node(current.val);
            Node nextCurrent = current.next;            
            current.next = copy;
            copy.next = nextCurrent;
            current = current.next.next;            
        }
        
        current = head;
        
        // Copying random node link for the copied Node.
        while(current != null)
        {
            if (current.random != null)
            {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        current = head;
        Node copiedHead = current.next;
        Node copiedCurrent = null;                
        
        // Separate merged lists
        while (current != null)
        {            
            copiedCurrent = current.next;                        
            current.next = current.next.next;
            
            if (current.next != null)
            {
                copiedCurrent.next = copiedCurrent.next.next;    
            }            
            current = current.next;
        }
        
        return copiedHead;
    }
}