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
    public ListNode swapPairs(ListNode head) {
        if (head==null) return head;
        ListNode first = head;
        ListNode prev = head;
        while(first!=null && first.next!=null){
            int temp = prev.val;
            prev.val = first.next.val;
            first.next.val = temp;
            first=first.next.next;
            prev = first;
        }
        return head;
    }
}