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
    private boolean find(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            if(targetSum==root.val){
                return true;
            }
            return false;
        }
        return find(root.left,targetSum-root.val)||find(root.right,targetSum-root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return find(root,targetSum);
    }
}