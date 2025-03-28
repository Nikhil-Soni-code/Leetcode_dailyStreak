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
    int idx = 0;
    private TreeNode construct(int[] preorder,int min,int max){
        if(idx==preorder.length){
            return null;
        }
        TreeNode root = null;
        if(preorder[idx]<max&&min<preorder[idx]){
            root = new TreeNode(preorder[idx++]);
        }else{
            return root;
        }
        root.left = construct(preorder,min,root.val);
        root.right = construct(preorder,root.val,max);
        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}