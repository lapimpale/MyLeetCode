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
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
// using map for memoization
     HashMap<TreeNode,Integer> map= new HashMap<>();
      return getMaxSum(root,map);
    }
// we can't choose two adjacent nodes in our sum so if we include current node in our sum we can't include it's children or if we don't include current node in our sum then we can include it's child nodes
    private int getMaxSum(TreeNode root,HashMap<TreeNode, Integer> map){
        if(root==null)
            return 0;
        int sum=0;
        if(map.containsKey(root))
            return map.get(root);
          
        int inc=root.val; // including current node in our ans
        if(root.left!=null){
            inc+=getMaxSum(root.left.left,map)+getMaxSum(root.left.right,map);
    }
        if(root.right!=null){
            inc+=getMaxSum(root.right.left,map)+getMaxSum(root.right.right,map);
        }
        // excluding current node
int exc=getMaxSum(root.left,map)+getMaxSum(root.right,map);
      sum=Math.max(inc,exc); 
    
       map.put(root,sum); 

    return map.get(root);
    }
}