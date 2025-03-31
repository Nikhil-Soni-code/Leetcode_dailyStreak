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
    private void construct(TreeNode root,StringBuilder str){
        if(root==null)return;
        str.append(root.val);
        if(root.left==null&&root.right==null)return;

        str.append('(');
        construct(root.left,str);
                str.append(')');

        if(root.right!=null){
                    str.append('(');

            construct(root.right,str);
                    str.append(')');

        }
    }
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        construct(root,str);
        return str.toString();
    }
}