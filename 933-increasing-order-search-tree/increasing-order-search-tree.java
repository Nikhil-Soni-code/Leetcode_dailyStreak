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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)return null;
        TreeNode head = increasingBST(root.left);
        root.left = null;
        if(head==null)head = root;
        else{
            TreeNode temp = head;
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = root;
        }
        root.right = increasingBST(root.right);
        return head;
    }
}