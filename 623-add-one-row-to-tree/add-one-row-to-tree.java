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
    private void add(TreeNode root,int val,int currDepth,int depth){
        if(root==null){
            return;
        }

        if(currDepth==depth){
            helper(root,val);
            return;
        }
        add(root.left,val,currDepth+1,depth);
        add(root.right,val,currDepth+1,depth);
    }
    private void helper(TreeNode root,int val){
        TreeNode newNode1 = new TreeNode(val);
        newNode1.left = root.left;
        root.left = newNode1;
        TreeNode newNode2 = new TreeNode(val);
        newNode2.right = root.right;
        root.right = newNode2;  
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        add(root,val,1,depth-1);
        return root;
    }
}