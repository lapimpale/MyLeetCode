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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean flag = false;
    
    if(root==null)
        return res;
    q.add(root);
    
    while(!q.isEmpty()){
        int nodeCount = q.size();
        List<Integer> li = new ArrayList<>();
        
        while(nodeCount-- > 0)
        {
            TreeNode node = q.poll();
            li.add(node.val);
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        if(flag)
            Collections.reverse(li);
        res.add(li);
        flag = !flag;
    }
    return res;
}
}