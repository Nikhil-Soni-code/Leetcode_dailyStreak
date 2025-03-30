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
class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList();
        queue.add(root);
        while(queue.peek().left!=null){
            queue.add(queue.peek().left);
            if(queue.peek().right==null)break;
            else{
                queue.add(queue.poll().right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        int parent = queue.peek().val;
        if(queue.peek().left==null){
            queue.peek().left = newNode;
            queue.add(newNode);
        }else{
            queue.poll().right = newNode;
            queue.add(newNode);
        }
        return parent;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */