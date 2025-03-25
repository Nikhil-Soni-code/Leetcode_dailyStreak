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
    private TreeNode convert(int beg,int[]nums,int end){
        if(beg>end){
            return null;
        }
        int mid = beg+(end-beg)/2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = convert(beg,nums,mid-1);
        newNode.right = convert(mid+1,nums,end);
        return newNode;


    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0,nums,nums.length-1);
    }
}