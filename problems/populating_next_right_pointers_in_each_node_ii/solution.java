/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
     public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left != null){
            if( root.right !=null){
                root.left.next = root.right;
                root.right.next= findNextNode(root.next);
            } else {
                root.left.next =findNextNode(root.next);
            }
        } else if( root.right !=null){
                root.right.next= findNextNode(root.next);
        }
        //Using NRL traversal
        connect(root.right);
        connect(root.left);
        return root;
    }
    
    private Node findNextNode(Node root){
        if(root==null){
            return null;
        }
        if(root.left!=null){
            return root.left;
        }
        if(root.right!=null){
            return root.right;
        }
        if(root.next!=null){
            return findNextNode(root.next);
        }
        return null;
    }
}