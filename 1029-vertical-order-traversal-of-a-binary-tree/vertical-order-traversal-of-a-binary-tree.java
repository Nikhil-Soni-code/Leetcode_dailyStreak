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
 class Pair{
    int vertical;
    int horizontal;
    TreeNode node;
    public Pair(int v,TreeNode val,int h){
        vertical = v;
        horizontal  = h;
        node = val;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,root,0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(map.containsKey(pair.vertical)){
                TreeMap<Integer,PriorityQueue<Integer>> temp = map.get(pair.vertical);
                if(temp.containsKey(pair.horizontal)){
                    temp.get(pair.horizontal).add(pair.node.val);
                }else{
                    PriorityQueue<Integer> pq = new PriorityQueue();
                    pq.add(pair.node.val);
                    temp.put(pair.horizontal,pq);
                }
            }else{
                TreeMap<Integer,PriorityQueue<Integer>> temp = new TreeMap();
                PriorityQueue<Integer> pq = new PriorityQueue();
                pq.add(pair.node.val);
                temp.put(pair.horizontal,pq);
                map.put(pair.vertical,temp);
            }
            if(pair.node.left!=null){
                queue.add(new Pair(pair.vertical-1,pair.node.left,pair.horizontal+1));
            }
            if(pair.node.right!=null){
                queue.add(new Pair(pair.vertical+1,pair.node.right,pair.horizontal+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        
        for(Integer i:map.keySet()){
            TreeMap<Integer,PriorityQueue<Integer>> temp = map.get(i);
            List<Integer> subList = new ArrayList<>();
            for(Integer j:temp.keySet()){
                PriorityQueue<Integer> pq = temp.get(j);
                while(!pq.isEmpty()){
                    subList.add(pq.poll());
                }
            }
            ans.add(new ArrayList(subList));
        }return ans;
    }
}