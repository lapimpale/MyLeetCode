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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmpL1 = l1, tmpL2 = l2, prev = null;
    int carry = 0;
    
    while(tmpL1 != null || tmpL2 != null) {
        int sum = carry;
        
        // check if tmp1 is valid (add to sum)
        if(tmpL1 != null) {
            sum += tmpL1.val;
            tmpL1 = tmpL1.next;
        }
        
        // check if tmp2 is valid (add to sum)
        // solution will not work if l2 is null
        if(tmpL2 != null) {
            sum += tmpL2.val;
            tmpL2.val = sum%10; //use tmpL2 pointer to store new value
            prev = tmpL2; // set the prev pointer (to be used when tmp2L is finished iterating)
            tmpL2 = tmpL2.next;
        } else {
            ListNode newNode = new ListNode();
            newNode.val = sum%10;
            prev.next = newNode; // continue the tmpL2 list (do not create new list)
            prev = newNode;
        }
        carry = sum >= 10 ? 1 : 0;
    }
    
    if(carry == 1) { // ensure carry is accounted for
        ListNode newNode = new ListNode();
        newNode.val = 1;
        prev.next = newNode;
    }
    
    return l2; //return l2
    }
}