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
    int i;
    private TreeNode bst(int min,int[] preorder,int max){
        if(i==preorder.length||preorder[i]>max||preorder[i]<min){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bst(min,preorder,root.val);
        root.right = bst(root.val,preorder,max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        return bst(-1,preorder,1001);
    }
}