class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Long> map = new HashMap();//
        long sum = 0;
        long ans = Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                long prevSum = map.get(nums[i]-k);
                long currSum = sum+nums[i];
                ans = Math.max(currSum-prevSum,ans);
            }if(map.containsKey(nums[i]+k)){
                long prevSum = map.get(nums[i]+k);
                long currSum = sum+nums[i];
                ans = Math.max(currSum-prevSum,ans);
            }
            if(map.containsKey(nums[i])){
                map.put(nums[i],Math.min(map.get(nums[i]),sum));
            }
            else{
                map.put(nums[i],sum);

            }
            sum += nums[i];
        }
        return (ans==Long.MIN_VALUE)?0:ans;
    }
}