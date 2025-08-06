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
    private void path(List<List<Integer>> ans,List<Integer> subAns,TreeNode root,int target){
        if(root.left==null&&root.right==null){
            if(target==root.val){
                subAns.add(root.val);
                ans.add(new ArrayList(subAns));
                subAns.remove(subAns.size()-1);
            }
            return;
        }
        subAns.add(root.val);
        if(root.left!=null){
            path(ans,subAns,root.left,target-root.val);
        }
        if(root.right!=null){
            path(ans,subAns,root.right,target-root.val);
        }
        subAns.remove(subAns.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList();
        if(root==null)return ans;
        path(ans,new ArrayList(),root,targetSum);
        return ans;
    }
}