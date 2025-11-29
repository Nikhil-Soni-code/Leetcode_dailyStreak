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
    private void build(List<String> ans,String path,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            path = path+root.val;
            ans.add(path);
        }
        path = path+root.val+"->";

        if(root.left!=null) {
            build(ans,path,root.left);
        }
        if(root.right!=null)
        {
            build(ans,path,root.right);
        }

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList();
        build(ans,"",root);
        return ans;
    }
}