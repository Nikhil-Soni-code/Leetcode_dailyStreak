class Solution {
    HashMap<Integer,List<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap();
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> indices = new ArrayList();
                indices.add(i);
                map.put(nums[i],indices);
            }
        }
        rand = new Random();
    }
    
    public int pick(int target) {
        int range = map.get(target).size();
        int idx = rand.nextInt(range);
        return map.get(target).get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */