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
    private boolean check(TreeNode root){
        if(root==null)return false;
        boolean left = check(root.left);
        if(!left)root.left = null;
        boolean right = check(root.right);
        if(!right)root.right = null;
        return left||right||root.val==1;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(!check(root))return null;
        return root;
    }
}