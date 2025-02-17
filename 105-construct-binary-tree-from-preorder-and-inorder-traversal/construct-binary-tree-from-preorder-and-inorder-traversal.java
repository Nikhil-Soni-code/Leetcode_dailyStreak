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
    private TreeNode create(int[] preorder,int[]inorder,HashMap<Integer,Integer> map,int start,int end){
        if(idx>=preorder.length||start>end){
            return null;
        }
        int i = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = create(preorder,inorder,map,start,i-1);
        root.right = create(preorder,inorder,map,i+1,end);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return create(preorder,inorder,map,0,inorder.length-1);

    }
}