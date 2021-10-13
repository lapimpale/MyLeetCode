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
   
       public int size(ListNode head){
ListNode temp= head;
int size=0;
while(temp!=null){
temp= temp.next;
size++;
}
return size;
}
public ListNode removeNthFromEnd(ListNode head, int n) {
ListNode temp= head;
int listsize= size(head);
if(listsize==1){
return null;
}
if(n==listsize){
return temp.next;
}
int i=0;
while(i !=(listsize-n-1)){
temp= temp.next;
i++;
}
temp.next= temp.next.next;
return head; 
    }
}