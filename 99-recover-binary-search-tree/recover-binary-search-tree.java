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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    private void recover(TreeNode root){
        if(root==null)return;
        recover(root.left);
        if(prev!=null&&root.val<prev.val){
            if(first==null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        recover(root.right);
    }
    private void swap(){
        if(first!=null&&second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    public void recoverTree(TreeNode root) {
        recover(root);
        swap();
    }
}