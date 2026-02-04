class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int sum = 0,count = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            int rem = sum%k;
            if(rem < 0)rem += k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem , map.getOrDefault(rem , 0)+1);
        }
        System.out.print(-1%2);
        return count;
    }
}