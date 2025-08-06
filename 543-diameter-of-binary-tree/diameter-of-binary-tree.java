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
    int d = 0;
    private int find(TreeNode root){
        if(root==null)return 0;
        int leftPart = 0;
        int rightPart = 0;
        if(root.left!=null){
            leftPart = find(root.left);
        }
        if(root.right!=null){
            rightPart = find(root.right);
        }
        d = Math.max(leftPart+rightPart,d);
        return 1+Math.max(leftPart,rightPart);
    }
    public int diameterOfBinaryTree(TreeNode root) {
find(root);
        return d;
    }
}