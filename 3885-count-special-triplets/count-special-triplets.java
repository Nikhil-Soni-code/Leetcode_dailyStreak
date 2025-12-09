class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer> map2 = new HashMap();
        for(int i=0;i<nums.length;i++){
            map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
        }
        int count = 0 , MOD = 1000000007;
        HashMap<Integer,Integer> map1 = new HashMap();
        for(int i=0;i<nums.length;i++){
            map2.put(nums[i],map2.get(nums[i])-1);
            if(map2.get(nums[i])==0){
                map2.remove(nums[i]);
            }
            if(map1.containsKey(nums[i]*2) && map2.containsKey(nums[i]*2)){
                count = (int)(count + ((long)map1.get(nums[i]*2)*map2.get(nums[i]*2)) % MOD) % MOD;
            }
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}