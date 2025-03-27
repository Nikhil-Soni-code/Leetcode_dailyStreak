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
    private void inorder(TreeNode root,List<Integer> inorder){
        if(root==null){
            return;
        }
        inorder(root.left,inorder);
        inorder.add(root.val);
        inorder(root.right,inorder);
    }
    private TreeNode create(List<Integer> inorder,int beg,int end){
        if(beg>end)return null;
        int mid = beg+(end-beg)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = create(inorder,beg,mid-1);
        root.right = create(inorder,mid+1,end);
        return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList();
        inorder(root,inorder);
        return create(inorder,0,inorder.size()-1);

    }
}