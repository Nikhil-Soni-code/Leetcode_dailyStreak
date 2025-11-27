class Pair{
    int ele;
    int count;
    public Pair(int ele,int count){
        this.ele = ele;
        this.count = count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b)->b.count-a.count);
        for(Integer i:map.keySet()){
            pq.add(new Pair(i,map.get(i)));
        }
        int[] ans = new int[k];
        int i =0;
        while(k!=0 && !pq.isEmpty()){
            ans[i++] = pq.poll().ele;
            k--;
        }
        return ans;

    }
}