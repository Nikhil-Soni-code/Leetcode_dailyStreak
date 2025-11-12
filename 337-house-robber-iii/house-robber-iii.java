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
    private int findMax(TreeNode root,int prev,HashMap<TreeNode,int[]> dp){
        if(root==null)return 0;
        if(dp.containsKey(root)&&dp.get(root)[prev]!=-1){
            return dp.get(root)[prev];
        }
        int pick = 0,notPick = 0;

        if(prev==0){
            pick = root.val+findMax(root.left,1,dp)+findMax(root.right,1,dp);
        }
        notPick = 0+findMax(root.right,0,dp)+findMax(root.left,0,dp);
        if(dp.containsKey(root)){
            int[] p = dp.get(root);
            p[prev] = Math.max(pick,notPick);
            dp.put(root,p);
        }else{
            int[] p = new int[2];
            Arrays.fill(p,-1);
            p[prev] = Math.max(pick,notPick);

            dp.put(root,p);
        }
        return Math.max(pick,notPick);
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode,int[]> dp = new HashMap();
        return findMax(root,0,dp);
    }
}