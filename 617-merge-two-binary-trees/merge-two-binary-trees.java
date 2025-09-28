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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null)return null;
        int val = 0;
        if(root1!=null){
            val+=root1.val;
        }
        if(root2!=null){
            val+=root2.val;
        }
        TreeNode newNode = new TreeNode(val);
        if(root1!=null&&root2!=null){
            newNode.left = mergeTrees(root1.left,root2.left);
            newNode.right = mergeTrees(root1.right,root2.right);
        }
        else if(root2!=null){
            newNode.left = mergeTrees(root1,root2.left);
            newNode.right = mergeTrees(root1,root2.right);
        }
        else if(root1!=null){
            newNode.left = mergeTrees(root1.left,root2);
            newNode.right = mergeTrees(root1.right,root2);
        }
        return newNode;
    }
}