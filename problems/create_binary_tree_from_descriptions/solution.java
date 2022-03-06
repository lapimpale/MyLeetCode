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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, Integer> prt = new HashMap<>();
        
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            boolean isLeft = d[2] == 1;
            prt.put(child, parent);

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            if (isLeft) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
        }
        
        int v = descriptions[0][0];
        while (prt.containsKey(v)) {
            v = prt.get(v);
        }
        return map.get(v);
    }
}