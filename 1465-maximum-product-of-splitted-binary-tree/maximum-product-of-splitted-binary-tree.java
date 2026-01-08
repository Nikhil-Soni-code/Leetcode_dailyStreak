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
    int MOD = 1000000007;
    long ans = 0;
    private int findTotalSum(TreeNode root){
        if(root==null)return 0;
        return root.val + findTotalSum(root.left) + findTotalSum(root.right);
    }
    private long maxProduct(TreeNode root,int totalSum){
        if(root==null)return 0;
        long leftSum = maxProduct(root.left,totalSum);
        long rightSum = maxProduct(root.right,totalSum);
        long sum1 = leftSum + rightSum + root.val;
        long sum2 = totalSum - sum1;
        ans = Math.max(ans,sum1 * sum2);

        return leftSum + rightSum + root.val;

    }
    
    public int maxProduct(TreeNode root) {
        int totalSum = findTotalSum(root);
        maxProduct(root,totalSum);
        return (int)(ans % MOD);
    }
}