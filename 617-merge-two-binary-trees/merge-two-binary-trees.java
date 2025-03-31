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
    private TreeNode merge(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return null;
        }
        TreeNode root = new TreeNode(0);
        if(root1!=null)root.val+=root1.val;
        if(root2!=null)root.val+=root2.val;
        root.left = merge((root1==null)?root1:root1.left,(root2==null)?root2:root2.left);
        root.right = merge((root1==null)?root1:root1.right,(root2==null)?root2:root2.right);
        return root;

    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
}