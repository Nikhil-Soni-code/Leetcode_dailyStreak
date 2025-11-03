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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap();
        HashSet<Integer> childSet = new HashSet();
        for(int i=0;i<descriptions.length;i++){
            int root = descriptions[i][0];
            int child = descriptions[i][1];
            childSet.add(child);
            boolean left = descriptions[i][2]==1?true:false;
            map.putIfAbsent(root,new TreeNode(root));
            map.putIfAbsent(child,new TreeNode(child));
            if(left){
                map.get(root).left = map.get(child);
            }
            else{
                map.get(root).right = map.get(child);

            }

        }
        for(Integer node:map.keySet()){
            if(!childSet.contains(node))return map.get(node);
        }
        return null;

    }
}