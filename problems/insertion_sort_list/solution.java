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
    public ListNode insertionSortList(ListNode head) {
         ListNode temp = head;
    int n=0;
    while(temp!=null)
    {
        n++;
        temp=temp.next;
    }
    temp=head;
    
    int arr[] = new int[n];
    int i=0;
    while(temp!=null)
    {
        arr[i]=temp.val;
        i++;
        temp=temp.next;
    }
    
    for(i=1;i<n;i++)
    {
        for(int j=i;j>0;j--)
        {
            if(arr[j-1]>arr[j])
            {
                int a=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=a;
            }
            else
            {
                break;
            }
        }
    }
 
    temp=head;
    i=0;
    while(temp!=null)
    {
        temp.val =arr[i];
        i++;
        temp=temp.next;
    }
    
    return head;
    }
}