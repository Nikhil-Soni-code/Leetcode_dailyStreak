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
    private void storeSumAtEachLevel(TreeNode root,int height,HashMap<Integer,Integer> map){
        if(root==null)return;
        map.put(height,map.getOrDefault(height,0)+root.val);
        storeSumAtEachLevel(root.left,height+1,map);
        storeSumAtEachLevel(root.right,height+1,map);

    }
    private void replace(TreeNode root,int height,HashMap<Integer,Integer> map){
        if(root==null)return;
        int sum = 0;
        if(root.left!=null){
            sum+=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;
        }
        if(root.left!=null)root.left.val = map.get(height+1)-sum;
        if(root.right!=null)root.right.val = map.get(height+1)-sum;

        replace(root.left,height+1,map);
        replace(root.right,height+1,map);



    }
    public TreeNode replaceValueInTree(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap(); //stores sum at each level
        storeSumAtEachLevel(root,0,map);
        root.val = 0;
        replace(root,0,map);
        return root;
    }
}