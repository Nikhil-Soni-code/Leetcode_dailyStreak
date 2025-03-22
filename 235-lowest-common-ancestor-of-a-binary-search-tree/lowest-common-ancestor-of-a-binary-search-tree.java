/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode lca(TreeNode key1,TreeNode root,TreeNode key2){
        if(key1.val<root.val&&key2.val>root.val)return root;
        if(root==key1||root==key2)return root;
        if(key2.val<root.val){
            TreeNode leftNode = lca(key1,root.left,key2);
            return leftNode;
        }
        else{
                        TreeNode rightNode = lca(key1,root.right,key2);
            return rightNode;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode key1 = (p.val<q.val)?p:q;
        TreeNode key2 = (p.val<q.val)?q:p;
        return lca(key1,root,key2);

    }
}