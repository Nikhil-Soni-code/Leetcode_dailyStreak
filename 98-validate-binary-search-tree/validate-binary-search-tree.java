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
    long prev = Long.MIN_VALUE;
    private boolean check(TreeNode root){
        if(root==null)return true;
        boolean left = check(root.left);
        if(root.val<=prev)return false;
        prev = Math.max(prev,root.val);
        boolean right = check(root.right);

return left&&right;


        
    }
    public boolean isValidBST(TreeNode root) {

        return check(root);
    }
}