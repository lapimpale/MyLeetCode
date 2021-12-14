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
    public void tnf(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        tnf(root.left, ans);
        ans.add(root.val);
        tnf(root.right, ans);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        tnf(root, ans);
        int li = 0;
        int ri = ans.size() - 1;
        while(li < ri){
            int left = ans.get(li);
            int right = ans.get(ri);
            if(left + right > k){
                ri--;
            }else if(left + right < k){
                li++;
            }else{
                return true;
            }
        }
        return false;
    }
}