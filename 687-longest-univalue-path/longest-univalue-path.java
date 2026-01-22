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
    int ans = 0;
    private int find(TreeNode root){
        if(root==null)return 0;
        int left = find(root.left);
        int right = find(root.right);
        int leftPath = 0,rightPath = 0;
        if(root.left!=null && root.left.val == root.val){
            leftPath = left+1;
        }
        if(root.right!=null && root.right.val == root.val){
            rightPath = right+1;
        }
        ans = Math.max(ans,leftPath+rightPath);
        return Math.max(leftPath,rightPath);


    }
    public int longestUnivaluePath(TreeNode root) {
        find(root);
        return ans;
    }
}