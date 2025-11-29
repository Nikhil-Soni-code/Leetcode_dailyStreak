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
    private TreeNode build(int[] preorder,HashMap<Integer,Integer> map,int beg,int end){
        if(idx==preorder.length||beg>end)return null;
        int node = preorder[idx++];
        int pos = map.get(node);
        TreeNode root = new TreeNode(node);
        root.left = build(preorder,map,beg,pos-1);
        root.right = build(preorder,map,pos+1,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,map,0,inorder.length-1);

    }
}