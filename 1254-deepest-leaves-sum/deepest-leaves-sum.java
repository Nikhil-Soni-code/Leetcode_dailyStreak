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
    int maxDepth = 0;
    int sum = 0;
    private void sum(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(maxDepth==depth){
                sum +=root.val;
            }
            else if(maxDepth<depth){
                maxDepth = depth;
                sum=root.val;
            }
        }
        sum(root.left,depth+1);
        sum(root.right,depth+1);


    }
    public int deepestLeavesSum(TreeNode root) {
        sum(root,0);
        return sum;
    }
}