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
    private int rangeSum(TreeNode root,int low,int high){
        if(root==null)return 0;
        int sum = 0;
        if(low<=root.val&&root.val<=high){
            sum+=root.val;
        }
        if(low<=root.val){
            sum+=rangeSum(root.left,low,high);
        }
        if(root.val<=high){
            sum+=rangeSum(root.right,low,high);
        }

        return sum;

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSum(root,low,high);
    }
}