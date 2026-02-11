class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int i = 0;
        for(int j=0 ; j<nums.length ; j++){
            sum += nums[j];
            while(sum * (j-i+1) >= k){
                sum -= nums[i];
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }
}