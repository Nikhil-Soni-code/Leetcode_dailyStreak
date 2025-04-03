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
    private void swap(int i,int j,List<TreeNode> list){
        TreeNode left = list.get(i);
        TreeNode right = list.get(j);

        int temp = left.val;
        left.val = right.val;
        right.val = temp; 

    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        int flag = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(flag==1){
                    list.add(node);
                }
            }
            if(flag==0){
                flag=1;
            }
            else{
                flag=0;
                int i=0,j=list.size()-1;
                while(i<j){
                    swap(i,j,list);
                    i++;j--;
                }
            }
        }
        return root;
    }
}