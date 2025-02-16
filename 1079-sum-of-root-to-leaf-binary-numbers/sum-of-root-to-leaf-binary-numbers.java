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
    private int sum(TreeNode root,StringBuilder sbr){
        if(root==null){
            return -1;
        }
        if(root.left==null&&root.right==null){
            sbr.append(root.val);
            int a = binaryToDecimal(sbr);
            sbr.deleteCharAt(sbr.length()-1);
            return a;
        }
        sbr.append(root.val);
        int l_sum = sum(root.left,sbr);
        int r_sum = sum(root.right,sbr);
        sbr.deleteCharAt(sbr.length()-1);

        if(l_sum==-1){
            l_sum=0;
        }
        if(r_sum==-1){
            r_sum=0;
        }
        return l_sum+r_sum;

    }
    private int binaryToDecimal(StringBuilder sbr){
        int decimal = 0;
        int pow = 0;
        for(int i=sbr.length()-1;i>=0;i--){
            if(sbr.charAt(i)=='1'){
                decimal += Math.pow(2,pow);
            }
            
            pow++;
        }
        return decimal;
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sum(root,new StringBuilder());
    }
}