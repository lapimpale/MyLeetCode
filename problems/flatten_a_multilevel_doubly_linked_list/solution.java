/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return null;

	Deque<Node> stack= new LinkedList<Node>();

	for(Node node= head; node.child!=null || node.next!=null || !stack.isEmpty(); node= node.next)

		 if(node.child!=null){

			 if(node.next!=null) stack.push(node.next);

			 node.next= node.child;

			 node.child= null;

			 node.next.prev= node;

		 }else if(node.next==null){

			 node.next= stack.pop();

			 node.next.prev= node;

		 }

	return head;
    }
}