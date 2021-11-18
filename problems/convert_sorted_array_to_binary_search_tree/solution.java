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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        
        return createTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode createTree(int[] array, int start, int end){
        
        if(end < start){
            return null;
        }
        
        TreeNode treeNode = new TreeNode();
        int mid = (start + end)/2;
        treeNode.val = array[mid];
        
        treeNode.left = createTree(array, start, mid - 1);
        treeNode.right = createTree(array, mid+1, end);
            
        
        return treeNode;
    }
}