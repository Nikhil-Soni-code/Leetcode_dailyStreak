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
    int maxCount = 0;
    private void findLongestPath(TreeNode root,boolean goLeft,int count){
        if(root==null){
            return;
        }
        maxCount = Math.max(maxCount,count);

        if(goLeft){
            findLongestPath(root.left,false,count+1);
            findLongestPath(root.right,true,1);
        }
        else{
            findLongestPath(root.right,true,count+1);
            findLongestPath(root.left,false,1);
        }

        
    }
    public int longestZigZag(TreeNode root) {
        findLongestPath(root,true,0);
        findLongestPath(root,false,0);

        return maxCount;
    }
}