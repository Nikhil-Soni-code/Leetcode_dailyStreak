class Solution {
    public int minLength(int[] nums, int k) {
        int i = 0,j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap();
        while(j<nums.length){
            if(!map.containsKey(nums[j])){
                sum += nums[j];
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(sum >= k){
                min = Math.min(min,j-i+1);
                if(map.get(nums[i]) == 1){
                    sum -= nums[i];
                }
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}