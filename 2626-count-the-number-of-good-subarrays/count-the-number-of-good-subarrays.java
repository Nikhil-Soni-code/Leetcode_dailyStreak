class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int pair = 0;
        int i=0,j=0;
        Map<Integer,Integer> map = new HashMap();
        while(j<nums.length){
            pair+=map.getOrDefault(nums[j],0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(pair>=k){
                ans += nums.length-j;
                map.put(nums[i],map.get(nums[i])-1);
                pair -= map.get(nums[i]);
                i++;
            }j++;
        }
        return ans;
    }
}