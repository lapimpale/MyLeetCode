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
    TreeNode A;
    TreeNode B;
    TreeNode ptr;
    public void recoverTree(TreeNode root) {
        helper(root);
        
        int temp = A.val;
        A.val = B.val;
        B.val = temp;
    }
    
    void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        
        if(ptr == null){
            ptr = root;
        } else {
            if(root.val < ptr.val && A == null){
                A = ptr;
                B = root;
            } else if (root.val < ptr.val){
                B = root;
            }
        }
        
        ptr = root;
        
        helper(root.right);
    }
}