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
    private void invert(TreeNode root){
        if(root==null)return;
        swap(root,root.left,root.right);
        invert(root.left);
        invert(root.right);
    }
    private void swap(TreeNode root,TreeNode left,TreeNode right){
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}