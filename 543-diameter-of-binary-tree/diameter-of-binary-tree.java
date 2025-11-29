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
    int max = 0;
    private int  findMax(TreeNode root){
        if(root==null)return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);

        max = Math.max(left+right,max);

        return 1+Math.max(left,right);


    }
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }
}