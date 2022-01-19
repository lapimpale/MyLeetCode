/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /* 
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == head) return head;
            if(fast == slow) {
                ptr1 = head;
                ptr2 = slow;
                while(ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        
        return null;
     }
     */
    
    public ListNode detectCycle(ListNode head) {
                ListNode slow = head;
                ListNode fast = head;
        
                while (fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
                    
                    if (fast == slow){
                        ListNode slow2 = head; 
                        while (slow2 != slow){
                            slow = slow.next;
                            slow2 = slow2.next;
                        }
                        return slow;
                    }
                }
                return null;
            }
}