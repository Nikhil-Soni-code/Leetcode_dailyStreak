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
    int sum = Integer.MIN_VALUE;
    private int find(TreeNode root){
        if(root==null)return 0;
        int left = Math.max(0,find(root.left));
        int right = Math.max(0,find(root.right));

        sum = Math.max(sum,left+right+root.val);

        return Math.max(left,right)+root.val;


    }
    public int maxPathSum(TreeNode root) {
        find(root);
        return Math.max(sum,find(root));

    }
}