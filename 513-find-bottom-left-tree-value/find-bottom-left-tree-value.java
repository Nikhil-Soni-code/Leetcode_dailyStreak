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
    int maxDepth = 0;
    int ans = 0;
    private void leftLeaf(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth>maxDepth){
            maxDepth = depth;
            ans = root.val;
            
        }
        leftLeaf(root.left,depth+1);
        leftLeaf(root.right,depth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        leftLeaf(root,1);
        return ans;
    }
}
//  */
// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         if(root==null){
//             return -1;
//         }
//         Queue<TreeNode> queue = new LinkedList();
//         queue.add(root);
//         int ans = -1;
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             ans = queue.peek().val;
//             for(int i=0;i<size;i++){
//                 TreeNode node = queue.poll();
//                 if(node.left!=null)queue.add(node.left);
//                 if(node.right!=null)queue.add(node.right);
//             }
//         }
//         return ans;

//     }
// }