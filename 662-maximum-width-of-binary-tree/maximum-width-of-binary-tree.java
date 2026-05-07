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
 class Pair{
    TreeNode node;
    int val;
    public Pair(TreeNode node,int val){
        this.node = node;
        this.val = val;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(root,0));
        int ans = 0;
        while(!queue.isEmpty()){
            int start = -1;
            int end = -1;
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                if(start==-1)start = pair.val;
                end = pair.val;
                if(node.left!=null){
                    queue.add(new Pair(node.left,2*pair.val+1));

                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,2*pair.val+2));
                }
            }
            ans = Math.max(ans,end-start+1);
        }return ans;
    }
}