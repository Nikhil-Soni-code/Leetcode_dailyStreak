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
    private int[] find(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left = find(root.left);
        int[] right = find(root.right);

        int avg = (root.val+left[0]+right[0])/(1+left[1]+right[1]);
        if(avg==root.val)ans++;
        return new int[]{left[0]+right[0]+root.val,1+left[1]+right[1]};
    }
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return ans;
    }
}