class Pair{
    int val;
    int count;
    public Pair(int val,int count){
        this.val = val;
        this.count = count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.count-a.count);
        for(Integer key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().val;
        }
        return ans;
    }
}