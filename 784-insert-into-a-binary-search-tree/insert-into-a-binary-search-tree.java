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
    private TreeNode createNewNode(int val){
        TreeNode newNode = new TreeNode(val);
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
    private void insert(TreeNode root,int val){

        if(val<root.val){
            if(root.left==null){
                root.left = createNewNode(val);
                return;
            }
            insert(root.left,val);
        }
        else{
            if(root.right==null){
                root.right = createNewNode(val);
                return;
            }
            insert(root.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
                if(root==null){
            return createNewNode(val);
        }
        insert(root,val);
        return root;
    }
}