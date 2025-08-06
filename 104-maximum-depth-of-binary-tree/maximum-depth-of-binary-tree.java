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
    private int find(TreeNode root){
        if(root==null)return 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left!=null){
            leftHeight = find(root.left);
        }
                if(root.right!=null){
            rightHeight = find(root.right);
        }
        return 1+Math.max(leftHeight,rightHeight);
    }
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return find(root);
    }
}