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
    private TreeNode build(TreeNode root){
        if(root==null)return null;
        TreeNode left = build(root.left);
        if(left==null){
            TreeNode right = build(root.right);
            root.right = right;
            return root;
            
        }
        root.left = null;
        TreeNode last = left;
        
        while(last.right != null)last = last.right;
        TreeNode right = build(root.right);
        root.right = left;
        last.right = right;
        return root;
    }
    public void flatten(TreeNode root) {
        build(root);
    }
}