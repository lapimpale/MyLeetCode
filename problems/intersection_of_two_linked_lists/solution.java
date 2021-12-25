/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null){
            return null;
        }
        ListNode fast = headB;
        ListNode slow = headA;
        int cnt1=0,cnt2=0;
        while(slow!=null){
            slow=slow.next;
            cnt1++;
        }
        while(fast != null){
            fast=fast.next;
            cnt2++;
        }
        slow=headA;
        fast=headB;
        int gap=0;
        if(cnt1>cnt2){
            gap = cnt1-cnt2;
            for(int i=0;i<gap;i++){
               slow=slow.next;
            }
        } 
        else{
             gap = cnt2-cnt1;
             for(int i=0;i<gap;i++){
               fast=fast.next;
            }
        }
        
        
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}