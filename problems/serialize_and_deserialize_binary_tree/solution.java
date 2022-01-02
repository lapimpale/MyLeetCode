/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        List<String> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n != null) {
                l.add("" + n.val);
                q.add(n.left);
                q.add(n.right);
            } else {
                l.add("#");
            }
        }
        
        return  String.join(",", l);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(",");
        Queue<TreeNode> qTree = new LinkedList<>();
        
        int i = 0;
        String value = i < arr.length ? arr[i++] : null;;
        
        if ("#".equals(value) || value == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(value));
        qTree.add(root);
        
        while(!qTree.isEmpty() && i < arr.length) {
            
            TreeNode prev = qTree.poll();
            String left = i < arr.length ? arr[i++] : null;
            String right = i < arr.length ? arr[i++] : null;;
            
            if (!"#".equals(left)) {
                prev.left = new TreeNode(Integer.parseInt(left));
                qTree.add(prev.left);
            }
            
            if (!"#".equals(right)) {
                prev.right = new TreeNode(Integer.parseInt(right));
                qTree.add(prev.right);
            }  
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));