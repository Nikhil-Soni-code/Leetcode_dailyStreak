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
    int maxCount = 0;
    HashMap<Integer,Integer> map = new HashMap();
    private int find(TreeNode root,List<Integer> list){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int sum = root.val;
        int left_value = find(root.left,list);
        if(left_value!=Integer.MAX_VALUE){
            sum+=left_value;
        }
        int right_value = find(root.right,list);
        if(right_value!=Integer.MAX_VALUE){
            sum+=right_value;
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        if(map.get(sum)>maxCount){
            list.clear();
            list.add(sum);
            maxCount = map.get(sum);
        }
        else if(map.get(sum)==maxCount){
            list.add(sum);
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList();
        find(root,list);
        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++){
            a[i] = list.get(i);
        }
        return a;
    }
}