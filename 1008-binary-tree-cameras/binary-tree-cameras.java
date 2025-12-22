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
    int cameras = 0;
    private int install(TreeNode root){
        if(root==null)return -1;
        if(root.left==null && root.right==null)return 0;

        int left = install(root.left);
        int right = install(root.right);

        if(left==0 || right==0){
            cameras++;
            return 1;
        }
        if(left==1 || right==1){
            return 2;
        }
        return 0;

    }
    public int minCameraCover(TreeNode root) {
        if(install(root)==0)cameras++;
        return cameras;
    }
}