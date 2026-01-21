class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        long count = nums.length;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(map.get(nums[i-1]) > map.get(nums[i]))count+=nums.length-i;
        }
        return count;
    }
}