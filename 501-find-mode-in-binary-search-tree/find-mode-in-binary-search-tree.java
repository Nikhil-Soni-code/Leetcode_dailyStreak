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
    int current = 0;
    int maxCount = 0;
    int currentCount = 0;
    private void inorder(TreeNode root,List<Integer> list){
        if(root==null)return;
        inorder(root.left,list);
        if(currentCount==0||root.val!=current){
            current = root.val;
            currentCount = 1;
        }
        else if(root.val==current){
            currentCount++;
        }
        if(currentCount>maxCount){
            maxCount = currentCount;
            list.clear();
            list.add(current);
        }
        else if(currentCount == maxCount){
            list.add(current);
        }
        inorder(root.right,list);
    }
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorder(root,list);
        System.out.println(list);
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }return ans;
    }
}