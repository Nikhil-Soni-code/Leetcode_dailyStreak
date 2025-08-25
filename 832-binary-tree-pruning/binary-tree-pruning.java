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

    // Helper function that checks if a subtree should be kept or pruned
    private boolean check(TreeNode root) {
        // Base case: if node is null, it has no "1", so return false
        if (root == null) return false;

        // Recursively check the left subtree
        boolean left = check(root.left);

        // If left subtree has no '1', prune it by setting root.left = null
        if (!left) root.left = null;

        // Recursively check the right subtree
        boolean right = check(root.right);

        // If right subtree has no '1', prune it by setting root.right = null
        if (!right) root.right = null;

        // Return true if:
        // 1. Left subtree contains '1'
        // 2. OR right subtree contains '1'
        // 3. OR current node itself is '1'
        return left || right || root.val == 1;
    }

    public TreeNode pruneTree(TreeNode root) {
        // If the entire tree has no '1', return null (prune whole tree)
        if (!check(root)) return null;

        // Otherwise, return the pruned root
        return root;
    }
}
