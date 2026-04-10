class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap();
        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                PriorityQueue<Integer> pq = map.get(nums[i]);
                pq.add(i);
                if(pq.size()>=3){
                    int a = pq.poll();
                    int b = pq.poll();
                    int c = pq.poll();
                    int diff = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                    pq.add(a);
                    pq.add(b);
                    pq.add(c);
                    ans = Math.min(ans,diff);
                }
            }
            else 
            {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(i);
                map.put(nums[i],pq);
            }
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}