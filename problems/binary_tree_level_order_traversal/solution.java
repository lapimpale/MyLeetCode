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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
    
    if(root == null){
        return res;
    }
    
    Queue<TreeNode> level = new LinkedList<>();
    level.add(root);
    
    while(true){
        
        int nodeCount = level.size();
        if(nodeCount == 0){
            return res;
        }
        
        List<Integer> row = new ArrayList<>();
        
        while(nodeCount > 0){
            TreeNode curr = level.remove();
            row.add(curr.val);
            if(curr.left != null){
                level.add(curr.left);
            }
            if(curr.right != null){
                level.add(curr.right);
            }
            nodeCount --;
        }
        
        res.add(row);
    }
}
}