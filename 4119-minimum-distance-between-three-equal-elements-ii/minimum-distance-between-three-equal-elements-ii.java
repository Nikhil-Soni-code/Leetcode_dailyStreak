class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap();
        int ans = Integer.MAX_VALUE;
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                List<Integer> pq = map.get(nums[i]);
                pq.add(i);
                if(pq.size()>=3){
                    int a = pq.get(pq.size()-1);
                    int b = pq.get(pq.size()-2);
                    int c = pq.get(pq.size()-3);
                    int diff = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                    ans = Math.min(ans,diff);
                }
            }
            else 
            {
                List<Integer> pq = new ArrayList();
                pq.add(i);
                map.put(nums[i],pq);
            }
        }
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}