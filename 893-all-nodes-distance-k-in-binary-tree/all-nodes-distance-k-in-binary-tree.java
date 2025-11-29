/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void storeParents(TreeNode root,HashMap<TreeNode,TreeNode> parents,TreeNode prev){
        if(root==null)return;
        if(prev!=null){
            parents.put(root,prev);
        }
        storeParents(root.left,parents,root);
        storeParents(root.right,parents,root);


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parents = new HashMap();
        storeParents(root,parents,null);
        HashSet<TreeNode> visited = new HashSet();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        List<Integer> ans = new ArrayList();
        int distance = 0;

        if(k==0){ans.add(target.val);return ans;}
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)){queue.add(node.left);visited.add(node.left);}
                if(node.right!=null && !visited.contains(node.right)){queue.add(node.right);visited.add(node.right);}
                if(parents.containsKey(node) && !visited.contains(parents.get(node))){queue.add(parents.get(node));visited.add(parents.get(node));}
            }
            if(distance==k){
                while(!queue.isEmpty()){
                    ans.add(queue.poll().val);
                }
                break;
            }
        }
        return ans;
    }
}