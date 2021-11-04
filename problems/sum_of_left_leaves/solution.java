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
/**class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Last Edit: 10 hours ago

NarutoBaryonMode

NarutoBaryonMode

 1629

This is a basic Tree Traversal problem. We need to explore all nodes in the tree and check if they are a left child node.

We can either do DFS (Depth-First Search) or BFS (Breadth-First Search) to solve this question.

DFS Recursive



 * DFS Recursive

 *

 * Time Complexity: O(N). All nodes will be visited.

 *

 * Space Complexity: O(H). Stack space.

 * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)

 *

 * N = Number of nodes. H = Height of the tree.

 */

class Solution {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {

            return 0;

        }

		

		// Checking if left Node is a leaf node

        if (root.left != null && root.left.left == null && root.left.right == null) {

            return root.left.val + sumOfLeftLeaves(root.right);

        }

		// Exploring the tree further.

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}