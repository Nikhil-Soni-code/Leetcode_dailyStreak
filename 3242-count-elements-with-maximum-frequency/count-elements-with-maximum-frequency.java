class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int maxCount = 0;
        int count = 0;
        for(Integer key:map.keySet()){
            if(map.get(key)>maxCount){
                maxCount = map.get(key);
                count = map.get(key);
            }
            else if(maxCount==map.get(key)){
                count+=map.get(key);
            }
        }
        return count;
    }
}