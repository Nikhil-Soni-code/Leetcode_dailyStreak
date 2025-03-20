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
    private void delete(TreeNode root,int key){
        if(root==null){
            return;
        }
        if(root.val>key){
            if(root.left!=null&&root.left.val==key){
                root.left = helper(root.left);
                return;
            }else{
                delete(root.left,key);
            }
        }else{
            if(root.right!=null&&root.right.val==key){
                root.right = helper(root.right);
                return;
            }else{
                delete(root.right,key);
            }
        }
    }
    private TreeNode helper(TreeNode root){
        if(root.right==null)return root.left;
        else if(root.left==null)return root.right;
        TreeNode rightNode = root.right;
        TreeNode leftNode = root.left;
        TreeNode lastRightNode = findLastRightNode(rightNode);
        lastRightNode.left = leftNode;
        return rightNode;
    }
    private TreeNode findLastRightNode(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        if(root.val == key){
            return helper(root);
        }
        delete(root,key);
        return root;
    }
}