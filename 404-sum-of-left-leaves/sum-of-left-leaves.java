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
    private int leftLeaf(TreeNode root,String leftOrRight){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            if(leftOrRight=="left")
            return root.val;
        }
        int left_node = leftLeaf(root.left,"left");
        int right_node = leftLeaf(root.right,"right");
        return left_node+right_node;

    }
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeaf(root,"");
    }
}