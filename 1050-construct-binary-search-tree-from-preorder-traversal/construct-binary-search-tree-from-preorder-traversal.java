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
    private TreeNode bst(int min,int []preorder,int max){
        if(idx==preorder.length)return null;
        TreeNode node;
        if(min<preorder[idx]&&preorder[idx]<max){
            node = new TreeNode(preorder[idx++]);
        }else{
            node = null;
            return node;
        }
        node.left = bst(min,preorder,node.val);
        node.right = bst(node.val,preorder,max);
        return node;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(Integer.MIN_VALUE,preorder,Integer.MAX_VALUE);
    }
}