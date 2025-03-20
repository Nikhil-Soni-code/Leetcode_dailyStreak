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
    long min_1 = Long.MAX_VALUE-1;
    long min_2 = Long.MAX_VALUE;
    private long secondMinimum(TreeNode root){
        if(root==null){
            return -1;
        }
        if(min_1>root.val){
            min_2 = min_1;
            min_1 = root.val;
        }
        else if(min_2>root.val&&min_1 != root.val){
            min_2 = root.val;
        }
        secondMinimum(root.left);
        secondMinimum(root.right);
        return min_2;

    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)return -1;
        long ans = secondMinimum(root);
        return (ans>=Long.MAX_VALUE-1)?-1:(int)ans;
    }
}