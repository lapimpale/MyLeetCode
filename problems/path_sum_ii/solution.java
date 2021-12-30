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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        if(targetSum == root.val && root.left == null && root.right == null) {
            List<Integer> current = new ArrayList<Integer>();
            current.add(root.val);
            result.add(current);
            return result;
        }
        
        List<List<Integer>> leftPathSum = pathSum(root.left,targetSum-root.val);
        List<List<Integer>> rightPathSum = pathSum(root.right,targetSum-root.val);
        if (leftPathSum != null && !leftPathSum.isEmpty()) {
            for(List<Integer> list:leftPathSum) {
                list.add(0,root.val);
            }
            result.addAll(leftPathSum);
        }
        if (rightPathSum!= null && !rightPathSum.isEmpty()) {
            for(List<Integer> list:rightPathSum) {
                list.add(0,root.val);
            }
            result.addAll(rightPathSum);
        }
        
        return result;
    }
}