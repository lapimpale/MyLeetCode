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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int sol = 0; 
        while (head!=null){
            arr.add(head.val);
            head = head.next;
        }
        int last = arr.size()-1;
        for(int i = 0; i < last;i++){
            sol = Math.max(sol,(arr.get(i)+arr.get(last-i)));
        }
        return sol;
    }
}