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
    private void depth(TreeNode root,HashMap<Integer,Integer> map,int depth){
        if(root==null)return;
        map.put(root.val,depth);
        depth(root.left,map,depth+1);
        depth(root.right,map,depth+1);
    }
        private TreeNode lcs(TreeNode root,HashMap<Integer,Integer> map,int depth){
        if(root==null)return null;
        if(map.get(root.val) == depth)return root;
        TreeNode left = lcs(root.left,map,depth);
        TreeNode right = lcs(root.right,map,depth);

        if(left != null && right != null)return root;

        if(left == null)return right;
        return left;

        

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap();
        depth(root,map,0);
        int maxLevel = 0;
        for(Integer value:map.values())maxLevel = Math.max(maxLevel,value);
        return lcs(root,map,maxLevel);
    }
}