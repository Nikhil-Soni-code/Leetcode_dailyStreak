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
    private TreeNode findLast(TreeNode node){
        if(node==null)return node;
        while(node.right!=null){
            node = node.right;
        }return node;
    }
    private TreeNode bst(TreeNode root){
        if(root==null)return null;
        TreeNode leftNode = bst(root.left);
        TreeNode rightNode = bst(root.right);
        TreeNode leftNodeEndPart = findLast(leftNode);
        root.left = null;
        if(leftNodeEndPart!=null){
            leftNodeEndPart.right = rightNode;
            root.right = leftNode;
        }else{
            root.right = rightNode;
        }
        
        return root;
    }
    public void flatten(TreeNode root) {
        bst(root);
    }
}