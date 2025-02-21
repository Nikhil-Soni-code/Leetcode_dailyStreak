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
    int idx = 0;
    private TreeNode create(HashMap<Integer,Integer> map,int[] inorder,int[] postorder,int start,int end){
        if(start>end||idx==-1){
            return null;
        }
        int i = map.get(postorder[idx]);
        TreeNode node = new TreeNode(postorder[idx]);
        idx--;
        node.right = create(map,inorder,postorder,i+1,end);
        node.left = create(map,inorder,postorder,start,i-1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = inorder.length-1;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return create(map,inorder,postorder,0,postorder.length-1);
    }
}