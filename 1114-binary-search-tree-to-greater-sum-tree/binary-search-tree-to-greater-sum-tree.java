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
    int prev = 0;
    private void change(TreeNode root){
        if(root==null)return;
        change(root.right);
        root.val = root.val+prev;
        prev = root.val;
        change(root.left);

    }
    public TreeNode bstToGst(TreeNode root) {
        change(root);
        return root;
    }
}