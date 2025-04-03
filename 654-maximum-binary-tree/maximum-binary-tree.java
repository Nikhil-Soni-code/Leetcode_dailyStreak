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
    private TreeNode construct(int i,int[] nums,int j){
        if(i>j)return null;
        int maxIndex = findMaxInRange(i,nums,j);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(i,nums,maxIndex-1);
        root.right = construct(maxIndex+1,nums,j);
        return root;

    }
    private int findMaxInRange(int i,int[] nums,int j){
        int max = -1;
        int maxIdx = -1;
        for(int k=i;k<=j;k++){
            if(max<nums[k]){
                max = Math.max(max,nums[k]);
                maxIdx = k;

            }
        }
        return maxIdx;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0,nums,nums.length-1);
    }
}