class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> freq = new HashMap();
        for(int i=0 ; i<nums.length ; i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer,Integer> map = new HashMap();
        for(Integer key:freq.keySet()){
            map.put(freq.get(key),map.getOrDefault(freq.get(key),0)+1);
        }
        for(int i=0 ; i<nums.length ; i++){
            int count = freq.get(nums[i]);
            if(map.get(count)==1)return nums[i];
        }return -1;
    }
}