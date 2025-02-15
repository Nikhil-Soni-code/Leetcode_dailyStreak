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
    private void generate(TreeNode root,List<String>ans,String s){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            
            ans.add(s+root.val);
            return;
        }
        generate(root.left,ans,s+root.val+"->");
        generate(root.right,ans,s+root.val+"->");

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        generate(root,ans,"");
        return ans;
    }
}