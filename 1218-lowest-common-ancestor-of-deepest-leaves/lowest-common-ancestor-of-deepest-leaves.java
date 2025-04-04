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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       if (root == null) return null;

        List<TreeNode> deepestLeaves = deepestleaf(root);
        TreeNode result = deepestLeaves.get(0);
        for (TreeNode node : deepestLeaves) {
            result = lca(root, result, node);
        }
        return result;
    }

    public TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return null;
        if (root == n1 || root == n2) return root;

        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public List<TreeNode> deepestleaf(TreeNode root) {
        List<TreeNode> li = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            li = new ArrayList<>(); // refresh list for current level
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                li.add(curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return li; 
    }
}