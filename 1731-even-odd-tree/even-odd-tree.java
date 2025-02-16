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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int prev = Integer.MIN_VALUE;
        boolean oddLevel = true;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(oddLevel){
                    if(prev>=node.val||(node.val%2==0)){
                        return false;
                    }
                }
                else{
                    if(prev<=node.val||(node.val%2==1)){
                        return false;
                    }
                }
                prev = node.val;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            if(oddLevel){
                oddLevel = false;
                prev = Integer.MAX_VALUE;

            }
            else{
                oddLevel = true;
                prev = Integer.MIN_VALUE;
            }
        }
        return true;
    }
}