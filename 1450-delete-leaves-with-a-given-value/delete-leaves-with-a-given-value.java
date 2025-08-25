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

    // Helper function: tries to remove target leaf nodes
    // Returns true if current node should also be removed
    private boolean remove(TreeNode root, int target) {
        // Base case: if node is null, nothing to remove
        if (root == null) return false;

        // Case 1: If current node is a leaf and equals target → mark for removal
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }

        // Recurse left and right
        boolean left = remove(root.left, target);
        boolean right = remove(root.right, target);

        // If left child should be removed, disconnect it
        if (left) root.left = null;

        // If right child should be removed, disconnect it
        if (right) root.right = null;

        // After removing children, check again:
        // If current node became a leaf AND equals target → remove it
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }

        // Otherwise, keep this node
        return false;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // If root itself should be removed, return null
        if (remove(root, target)) return null;

        // Otherwise return the pruned tree
        return root;
    }
}
