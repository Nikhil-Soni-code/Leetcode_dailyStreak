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
    private int find(TreeNode root,long targetSum,HashMap<Long,Long> map,long sum){
        if(root==null){
            return 0;
        }
        long newSum = sum+root.val;
        int path = 0;
        if(newSum==targetSum||map.containsKey(newSum-targetSum))path+=map.get(newSum-targetSum);
        map.put(newSum,map.getOrDefault(newSum,0l)+1);
        path+=find(root.left,targetSum,map,newSum);
        path+=find(root.right,targetSum,map,newSum);

        map.put(newSum,map.get(newSum)-1);
        if(map.get(newSum)==0)map.remove(newSum);
        return path;
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Long> map = new HashMap();
        map.put(0l,1l);
        return find(root,targetSum,map,0);
    }
}