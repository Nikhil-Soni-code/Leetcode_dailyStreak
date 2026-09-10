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
 class Ans{
    int sum;
    int n;
    int sol;
    public Ans(int sum , int n , int sol){
        this.sum = sum;
        this.n = n;
        this.sol = sol;
    }
 }
class Solution {
    
    private Ans find(TreeNode root){
        if(root==null)return new Ans(0,0,0);
        Ans left = find(root.left);
        Ans right = find(root.right);

        int ans = 0;
        if((left.sum + right.sum + root.val) / (left.n + right.n + 1)==root.val){
            ans++;
        }
        return new Ans(left.sum + right.sum + root.val , left.n + right.n + 1 , ans+left.sol+right.sol);
    }
    public int averageOfSubtree(TreeNode root) {
        return find(root).sol;
    }
}