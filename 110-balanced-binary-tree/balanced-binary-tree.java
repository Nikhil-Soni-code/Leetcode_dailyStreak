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
    boolean balance = true;
    private int find(TreeNode root){
        if(root==null)return 0;
        int left = find(root.left);
        int right = find(root.right);

        if(Math.abs(left-right)>1){
            balance = false;
        }
        return Math.max(left,right)+1;

    }
    public boolean isBalanced(TreeNode root) {
        find(root);
        return balance;

    }
}