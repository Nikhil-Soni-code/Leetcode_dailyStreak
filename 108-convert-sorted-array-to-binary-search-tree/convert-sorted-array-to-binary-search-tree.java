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
    private TreeNode convert(int i,int[] nums,int j){
        if(i>j)return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(i,nums,mid-1);
        root.right = convert(mid+1,nums,j);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0,nums,nums.length-1);
    }
}