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
    private void storeParents(TreeNode root,TreeNode prev,HashMap<TreeNode,TreeNode> parents){
        if(root==null)return;
        parents.put(root,prev);
        storeParents(root.left,root,parents);
        storeParents(root.right,root,parents);

    }
    private TreeNode findTarget(TreeNode root,int start){
        if(root==null)return null;
        if(root.val==start)return root;
        TreeNode left = findTarget(root.left,start);
        if(left!=null)return left;
        return findTarget(root.right,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> parents = new HashMap();
        HashSet<TreeNode> infected = new HashSet();
        storeParents(root,null,parents);

        Queue<TreeNode> queue = new LinkedList();
        TreeNode target = findTarget(root,start);

        if(target==null)return 0;
        queue.add(target);
        infected.add(target);
        int time = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null&&!infected.contains(node.left)){queue.add(node.left);infected.add(node.left);}
                if(node.right!=null&&!infected.contains(node.right)){queue.add(node.right);infected.add(node.right);}
                if(parents.get(node)!=null && !infected.contains(parents.get(node))){
                    queue.add(parents.get(node));
                    infected.add(parents.get(node));
                }
            }
            time++;
        }
        return time;
    }
}