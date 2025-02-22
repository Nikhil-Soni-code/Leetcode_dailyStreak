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
    private int findDepth(TreeNode root,int node,int depth){
        if(root==null){
            return -1;
        }
        if(root.val==node){
            return depth;
        }
        int ln = findDepth(root.left,node,depth+1);
        if(ln!=-1)return ln;
        int rn = findDepth(root.right,node,depth+1);
        return rn;

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int depth1 = findDepth(root,x,0);
        int depth2 = findDepth(root,y,0);
        return depth1==depth2&&!isSiblings(root,x,y);//same leve l&& not real siblings
    }
    private boolean isSiblings(TreeNode root,int x,int y){
        if(root==null){
            return false;
        }
        if(root.left!=null&&root.right!=null&&(root.left.val==x&&root.right.val==y||root.left.val==y&&root.right.val==x)){
            return true;
        }
        return isSiblings(root.left,x,y)||isSiblings(root.right,x,y);

    }
}