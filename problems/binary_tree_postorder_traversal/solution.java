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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        addNodes(result, root);
        return result;
    }
    
    private void addNodes(List<Integer> result, TreeNode node) {
        if (node == null) return;
        addNodes(result, node.left);
        addNodes(result, node.right);
        result.add(node.val);
    }
}
