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
    private boolean check(TreeNode part1 , TreeNode part2){
        if(part1==null&&part2==null)return true;
        if(part1==null||part2==null)return false;
        if(part1.val!=part2.val)return false;
        return check(part1.left,part2.right)&&check(part1.right,part2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return check(root.left,root.right);
    }
}