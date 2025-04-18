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
    long min = Long.MIN_VALUE;
    private boolean isValid(TreeNode root){
        if(root==null){
            return true;
        }
        boolean left = isValid(root.left);
        if(!left)return false;
        if(root.val<=min){
            return false;
        }
        min = root.val;
        boolean right = isValid(root.right);
        return right;
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }
}