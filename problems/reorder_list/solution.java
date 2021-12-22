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
    public void reorderList(ListNode head) {
        ListNode temp = head;
        Deque<ListNode> stack = new LinkedList<>();
        //add elements to the stack
        while(temp!=null) {
            stack.push(temp);
            temp=temp.next;
        }
        
        int count=(stack.size()-1)/2;
        temp=head;
        //start taking each element from stack and add it to the list.
        while (count-->0) {
            ListNode next = temp.next;
            temp.next=stack.pop();
            temp.next.next=next;
            temp=next;
        }
        //reset last node next to avoid loop in linkedlist
        stack.pop().next=null;
    }
}