class Solution {
    public long countBadPairs(int[] nums) {
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0 ; i<nums.length ; i++){
            ans = ans + map.getOrDefault(nums[i]-i,0);
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
        }
        long n = nums.length;
        long total = (n * (n - 1)) / 2;
        return total-ans;
    }
}