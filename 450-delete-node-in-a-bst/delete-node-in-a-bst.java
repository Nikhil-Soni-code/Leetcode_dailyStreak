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
            TreeNode right = root.right;
            if(right==null){
                return root.left;
            }
            if(root.left==null)return root.right;
            TreeNode temp = right;
            while(temp.left!=null){
                temp = temp.left;
            }
            temp.left = root.left;
            return right;
        }
        if(root.val > key){
            root.left = delete(root.left,key);
        }
        if(root.val < key){
            root.right = delete(root.right,key);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
}