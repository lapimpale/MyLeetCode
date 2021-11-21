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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length-1;
        return buildTree(inorder, postorder, 0, len, 0, len);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        //if we covers all index then inStart will greater than inEnd, have to stop there
        if(inStart > inEnd)
            return null;
        //post order keep the root in the end that's why will pick the root from there
        TreeNode root = new TreeNode(postorder[postEnd]);
        //search this root in inorder which will tell how many nodes are there in left & right
        //For eg : got root 3 from postorder then look for 3 in inorder [9,3,15,20,7] : [9] is left subtree & [15,20,7] is right subtree
        int rootInInorder = 0;
        for(rootInInorder = inStart; rootInInorder<inEnd; rootInInorder++){
            if(inorder[rootInInorder] == root.val)
                break;
        }
        //Calculating left & right sub tree to use to calculated postStart & postEnd
        int leftSubSize = rootInInorder - inStart;
        int rightSubSize = inEnd - rootInInorder;
        
        //break the tree into subtrees      
        root.left = buildTree(inorder, postorder, inStart, rootInInorder - 1, postStart, postStart + leftSubSize -1);
        root.right = buildTree(inorder, postorder, rootInInorder + 1, inEnd, postEnd - rightSubSize, postEnd - 1);
        return root;
    }
}