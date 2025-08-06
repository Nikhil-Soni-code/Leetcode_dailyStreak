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
    private boolean check(TreeNode root,TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null||left.val!=right.val)return false;
        return check(root,left.left,right.right)&&check(root,left.right,right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return false;
        return check(root,root.left,root.right);
    }
}