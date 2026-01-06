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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        int maxLevel = 0;
        int max = Integer.MIN_VALUE;
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            level ++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }

            if(sum > max){
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;

    }
}