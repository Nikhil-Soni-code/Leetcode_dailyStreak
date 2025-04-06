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
    private void tree(TreeNode root,List<Integer> list){
        if(root==null)return;
        tree(root.left,list);
        list.add(root.val);
        tree(root.right,list);
    }
    private List<Integer> merge(List<Integer> list1,List<Integer> list2){
        int i=0,j=0;
        List<Integer> list = new ArrayList();

        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                list.add(list1.get(i++));
            }else{
                list.add(list2.get(j++));
            }
        }
        while(i<list1.size()){
            list.add(list1.get(i++));
        }
                while(j<list2.size()){
            list.add(list2.get(j++));
        }
        return list;

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        tree(root1,list1);
        List<Integer> list2 = new ArrayList();
        tree(root2,list2);
        return merge(list1,list2);
    }
}