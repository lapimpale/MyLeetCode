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
    int ans=0;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
    int l=minDepth(root.left);
        int r=minDepth(root.right);
        if(l==0 && r!=0){return r+1;}
        else if(l!=0 && r==0){return l+1;}
        else return 1+Math.min(l,r);
    }
}