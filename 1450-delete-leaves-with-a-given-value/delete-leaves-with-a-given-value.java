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
    private boolean remove(TreeNode root,int target){
        if(root==null)return false;
        if(root.left==null&&root.right==null&&root.val==target)return true;
        boolean left = remove(root.left,target);
        boolean right = remove(root.right,target);

        if(left)root.left=null;
        if(right)root.right=null;
        
        if(root.left==null&&root.right==null&&root.val==target)return true;
        return false;



    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(remove(root,target))return null;
        return root;
    }
}