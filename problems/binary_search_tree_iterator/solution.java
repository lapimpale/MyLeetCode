/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    List<TreeNode> list = new ArrayList<>();
int index = 0;
public void inOrderTraversal(TreeNode root, List<TreeNode> list){
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    
    while(curr != null || !stack.isEmpty()){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        list.add(curr);
        curr = curr.right;
    }
    
    return;
}

public BSTIterator(TreeNode root) {
    inOrderTraversal(root, list);
    
}

public int next() {
    return list.get(index++).val;
}

public boolean hasNext() {
    if(index < list.size()) return true;
    return false;
}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */