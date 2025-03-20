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
    int k = -1;
    int ans = -1;
    private void findKthSmallest(TreeNode root){
        if(root==null)return;
        findKthSmallest(root.left);
        k--;
        if(k==0){
            ans = root.val;
            k--;
            return;
        }
        findKthSmallest(root.right);


    }
    public int kthSmallest(TreeNode root, int key) {
        k = key;
        findKthSmallest(root);
        return ans;
    }
}