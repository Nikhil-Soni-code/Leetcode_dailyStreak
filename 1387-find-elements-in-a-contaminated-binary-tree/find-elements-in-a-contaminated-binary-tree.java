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
class FindElements {
    HashSet<Integer> set = new HashSet();
    public FindElements(TreeNode root) {
        if(root==null){
            return;
        }
        set.add(0);
        root.val = 0;
        recover(root,0,false,false);
    }
    private void recover(TreeNode root,int prevValue,boolean leftNode,boolean rightNode){
        if(root==null)return;
        if(leftNode){
            set.add(prevValue*2+1);
            root.val = prevValue*2+1;
        }
        else if(rightNode){
            set.add(prevValue*2+2);
            root.val = prevValue*2+2;
        }
        recover(root.left,root.val,true,false);
        recover(root.right,root.val,false,true);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */