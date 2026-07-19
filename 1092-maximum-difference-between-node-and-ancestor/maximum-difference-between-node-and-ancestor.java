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
    private int find(TreeNode root,int min, int max){
        if(root==null)return 0;
        int ans = Math.max(Math.abs(min-root.val),Math.abs(max-root.val));
        int left = find(root.left,Math.min(min,root.val),Math.max(max,root.val));
        int right = find(root.right,Math.min(min,root.val),Math.max(max,root.val));
        return Math.max(ans,Math.max(right,left));
    }
    public int maxAncestorDiff(TreeNode root) {
        return find(root,root.val,root.val);
    }
}