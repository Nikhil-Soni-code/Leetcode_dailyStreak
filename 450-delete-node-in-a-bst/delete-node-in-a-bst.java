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
    private TreeNode delete(TreeNode root,int key){
        if(root==null)return null;
        if(root.val == key){
            return helper(root);
        }
        root.left = delete(root.left,key);
        root.right = delete(root.right,key);

        return root;
    }
    private TreeNode helper(TreeNode root){
        if(root.right == null){
            return root.left;
        }
        if(root.left == null){
            return root.right;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;//newRoot
        TreeNode temp = rightNode;
        while(temp.left!=null){
            temp = temp.left;
        }
        temp.left = leftNode;
        return rightNode;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
}