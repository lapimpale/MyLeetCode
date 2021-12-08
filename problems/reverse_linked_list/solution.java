/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
         return recReverse(null,head);
}

public ListNode recReverse(ListNode prev, ListNode cur){
    if(cur==null)
        return prev;
    ListNode temp = cur.next;
    cur.next = prev;
    return recReverse(cur,temp); 
    }
}