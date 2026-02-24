class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        long pairs = 0;
        int i = 0,j = 0;
        long count=0;
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            pairs += map.get(nums[j])-1;
            while(pairs >= k){
                count += nums.length-j;
                map.put(nums[i],map.get(nums[i])-1);
                pairs -= map.get(nums[i]);
                i++;
            }

            j++;
        }
        return count;
    }
}