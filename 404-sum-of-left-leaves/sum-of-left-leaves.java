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
    private int leftLeaf(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans = 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null)ans+= root.left.val;
        int left = leftLeaf(root.left);
        int right = leftLeaf(root.right);
        return ans+left+right;

    }
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeaf(root);
    }
}