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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode newHead = null;
        ListNode newTail = null;
        
        ListNode temp = head.next; 
        int sum = 0;

        while(temp != null)
        {
            if(temp.val == 0)
            {
                temp.val = sum;
                sum = 0;

                if(newHead == null)
                {
                    newHead = newTail = temp;
                }
                else
                {
                    newTail.next = temp;
                    newTail = temp;
                }
            }
            else
            {
                sum = sum + temp.val;
            }

            temp = temp.next;
        }
        
        return newHead;

    }
}