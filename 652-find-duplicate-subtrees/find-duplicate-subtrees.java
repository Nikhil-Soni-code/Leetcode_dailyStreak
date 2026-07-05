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
    private String find(TreeNode root , HashMap<String,Integer> map , List<TreeNode> ans){
        if(root==null)return "#";
        String left = find(root.left,map,ans);
        String right = find(root.right,map,ans);
        String str = root.val+","+left+","+right;
        if(map.containsKey(str) && map.get(str)==1){
            ans.add(root);
        }
        map.put(str,map.getOrDefault(str,0)+1);
        return str;

    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList();
        HashMap<String,Integer> map = new HashMap();
        find(root,map,ans);
        return ans;
    }
}