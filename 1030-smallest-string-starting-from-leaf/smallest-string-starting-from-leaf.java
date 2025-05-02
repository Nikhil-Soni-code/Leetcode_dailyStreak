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
    private String findSmall(TreeNode root,StringBuilder sbr){
        if(root==null){
            return null;    
        }
        if(root.left==null&&root.right==null){
            sbr.append((char)(root.val+97));
            sbr.reverse();
            String res = sbr.toString();
            sbr.reverse();
            sbr.deleteCharAt(sbr.length()-1);
            return res;
        }
        sbr.append((char)(root.val+97));
        String leftPart = findSmall(root.left,sbr);
        String rightPart = findSmall(root.right,sbr);

        sbr.deleteCharAt(sbr.length()-1);
        if(leftPart==null)return rightPart;
        if(rightPart==null)return leftPart;
        
        if(leftPart.compareTo(rightPart)<=0){
            return leftPart;
        }return rightPart;

    }
    public String smallestFromLeaf(TreeNode root) {
        return findSmall(root,new StringBuilder());
    }
}